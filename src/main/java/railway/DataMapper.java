package railway;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pro-27 on 16.04.2018.
 */
public class DataMapper {

    Connection connection;
//    String address = "jdbc:postgresql://localhost:5432/RealWay";
//    String user = "postgres";
//    String password = "123";

    public void connectSQL(String address, String user, String password) throws ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");
        Statement statement;
       try {

            connection = DriverManager.getConnection(address, user, password);
            statement = connection.createStatement();


        }catch (Exception ex){
            System.out.println(ex.getMessage());
           ex.printStackTrace();
        }



    }



    public HashSet<City> loadCities() throws ClassNotFoundException {

        HashSet<City> Cities = new HashSet<>();



        try {
            //Boolean flag = connectSQL(address, user,password);


           // Connection connection = DriverManager.getConnection(address, "postgres", "123");
            Statement statement = connection.createStatement();
            String query = "Select name From cities;";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {

                String name = result.getString("name");
                City city = new City(name);
                Cities.add(city);
            }



       } catch (SQLException e) {

            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
           e.printStackTrace();
       }

        return Cities;

    }

    public HashSet<Trip> loadTrip() throws ClassNotFoundException {

        HashSet<Trip> trips = new HashSet<>();



       try {
           // Boolean flag = connectSQL(address, user,password);
            String query = "Select ID,number,city_from,city_to,departure_date From trips;";
           Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

                while (result.next()) {

                    int id = result.getInt("ID");
                    String namber = result.getString("number");
                    String cityFrom = result.getString("city_from");
                    String cityTo = result.getString("city_to");
                    LocalDate DipDate = result.getDate("departure_date").toLocalDate();
                    LocalTime DipTime = result.getTime("departure_date").toLocalTime();
                    LocalDateTime DipDatTime = LocalDateTime.of(DipDate, DipTime);

                    City cityFromLink = loadCities().stream().filter(c -> (c.name == null ? cityFrom == null : c.name.equals(cityFrom))).collect(Collectors.toList()).isEmpty() ? new City(cityFrom) : loadCities().stream().filter(c -> (c.name == null ? cityFrom == null : c.name.equals(cityFrom))).collect(Collectors.toList()).get(0);
                    City cityToLink = loadCities().stream().filter(c -> (c.name == null ? cityTo == null : c.name.equals(cityTo))).collect(Collectors.toList()).isEmpty() ? new City(cityFrom) : loadCities().stream().filter(c -> (c.name == null ? cityTo == null : c.name.equals(cityTo))).collect(Collectors.toList()).get(0);
//                String pattern = "HH:mm:ss dd.MM.yyyy";
//                DateTimeFormatter f = DateTimeFormatter.ofPattern(pattern);
//                LocalDateTime date_ = LocalDateTime.parse(DipDate, f);

                    Trip trip = new Trip(namber, cityFromLink, cityToLink, DipDatTime);
                    trips.add(trip);

                }


        } catch (SQLException e) {

        System.out.println(e.getMessage());
        System.out.println(e.getSQLState());
            e.printStackTrace();
    }

        return trips;

    }

}
