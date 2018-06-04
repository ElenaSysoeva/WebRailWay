package railway;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by pro-27 on 26.02.2018.
 */
public class railway {
//
//    @Test
//    public void test() {
//        boolean cat = false;
//        try {
//            railway.sailTicket С = new railway.sailTicket();
//            City msc = new City("Москва");
//            //City omsk = new City("Омск");
//            //City nov = new City("Новосибирск");
//
//            С.addCity(msc);
//            //С.addCity(omsk);
//            С.linkCities(msc, msc);
//
//
//        } catch (IllegalArgumentException e) {
//
//            cat = true;
//
//        }
//
//        Assert.assertTrue(cat);
//
//        // Assert.assertTrue(С.checkLink(msc, omsk));//проверка
//
////        ArrayList <City> list = new ArrayList<City>();
////        City msc = new City("msc");
////        list.add(msc);
////        Assert.assertTrue(list.contains(msc));//проверка
//
//    }
//
//    @Test
//    public void checkCity() {
//
//        railway.sailTicket С = new railway.sailTicket();
//        City msc = new City("Москва");
//        City omsk = new City("Омск");
//        City nov = new City("Новосибирск");
//
//        С.addCity(msc);
//        С.addCity(omsk);
//        С.linkCities(msc, omsk);
//
//        Assert.assertTrue(С.checkLink(msc, omsk));//проверка
//        Assert.assertTrue(С.checkLink(omsk, msc));//проверка
//        Assert.assertFalse(С.checkLink(msc, nov));//проверка
//        Assert.assertFalse(С.checkLink(omsk, nov));//проверка
//
//
//    }
//
//    @Test
//    public void checkAddCity() {
//        boolean cat = false;
//        railway.sailTicket C = new railway.sailTicket();
//        City msc = new City("Москва");
//        C.addCity(msc);
//
//        try {
//            C.addCity(msc);
//
//
//        } catch (IllegalArgumentException e) {
//            cat = true;
//
//        }
//
//        Assert.assertTrue(cat);
//
//
//    }
//
//    @Test
//    public void testCreatTrip() {
//
//        railway.sailTicket с = new railway.sailTicket();
//        String tNumber = "РТ-1500";
//        City NVS = new City("Новосибирск");
//        City OMS = new City("Омск");
//        String tDate = "19:27:00 19.05.2018";
//        с.creatTrip(tNumber, NVS, OMS, tDate);
//
//
//    }
//
//    @Test
//    public void checkTripEsterday(){
//        boolean cat = false;
//        railway.sailTicket с = new railway.sailTicket();
//        String tNumber = "РТ-1500";
//        City NVS = new City("Новосибирск");
//        City OMS = new City("Омск");
//        String tDate = "19:27:00 25.09.2018";
//
//        try {
//
//            с.creatTrip(tNumber, NVS, OMS, tDate);
//        }catch(IllegalArgumentException e) {
//
//            cat = true;
//            System.out.println(e.getMessage());
//        }
//
//        Assert.assertTrue(cat);
//
//
//
//
//
//    }
//
    @Test
    public  void  testConnection() throws ClassNotFoundException {
        String address = "jdbc:postgresql://localhost:5432/RealWay";
        String user = "postgres";
        String password = "123";

DataMapper onesMapper = new DataMapper();
onesMapper.connectSQL(address,user,password);

       // DataMapper onesMapper = new DataMapper();

       HashSet s=onesMapper.loadCities();

       HashSet<Trip> t = onesMapper.loadTrip();


       Assert.assertNotEquals(0,s.size());


    }

}
