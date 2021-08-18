package taco;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    //在spring实战上学习的第一种请求方式
    //get请求，到根目录，返回home页面
    //thymeleaf  home  指向了resources/templates/home.html
    @GetMapping("/")
    public String home() {
        return "home";
    }


    //这是我从另一个教程上看到的另外一种请求方式
    //ResourceBody表示不进行跳转，而直接返回字符串
    //@ResponseBody + @Controller =RestController
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "helloworld";
    }
}
