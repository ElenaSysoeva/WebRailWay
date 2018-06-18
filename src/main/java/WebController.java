import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import railway.*;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashSet;

@org.springframework.stereotype.Controller
@EnableAutoConfiguration



public class WebController {

    public static void main(String[] args) {
        SpringApplication.run(WebController.class,args);
    }


//    @ResponseBody   //то что будет возвращено-тело ответа(картинка)
//    @RequestMapping("/") // адрес запрос к которому мы обрабатываем, 'путь к адресу ресурса'
//
//    public String Home (){
//        //Метод обрабатывающий запросы браузера
//        return "MustWork";
//    }

    @GetMapping("/greeting")
    public String greet (@RequestParam(name ="str", required = false, defaultValue = "world") String name, Model model ){
            model.addAttribute("name", "Elena");

        return "greeting";
    }

    @GetMapping("/mainPage")  //наименование в url для вызова
    public String mainЗ (){
        return "main";
    }

    @GetMapping("/search")  //наименование в url для вызова
    public String search (@RequestParam(name = "CityFrom") String cityFrom,   //принимает от сервера
                          @RequestParam(name = "CityTo") String cityTo,
                          @RequestParam(name = "DepDate") String depDate, Model model) throws ClassNotFoundException {    ///ожидаемые параметры при запросе на search


        Controller cont = new Controller();
        City cityF = new City(cityFrom);
        City cityT = new City(cityTo);

//Подкл к sql
        String address = "jdbc:postgresql://localhost:5432/RealWay";
        String user = "postgres";
        String password = "123";
        DataMapper dm = new DataMapper();
        dm.connectSQL(address,user,password);


        HashSet<Trip> tripColl =  dm.loadTrip();
        model.addAttribute("c_from", cityFrom) ;
        model.addAttribute("c_to", cityTo) ;
        model.addAttribute("c_date", depDate) ;
        model.addAttribute("tripCollection", tripColl) ;






        HashSet <Ticket>  ticketSet = cont.saleTickets(cityF,  cityT,  depDate);

        model.addAttribute("c_from", cityFrom) ;
        model.addAttribute("c_to", cityTo) ;
        model.addAttribute("c_date", depDate) ;
        model.addAttribute("ticketSet", ticketSet) ;

        return "result";
    }





}
