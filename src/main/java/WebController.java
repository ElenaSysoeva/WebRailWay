import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Name;

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

}
