package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return  "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http의 body부에 이 내용을 직접 넣겠다, 즉 view가 없음
    public  String helloString(@RequestParam("name") String name){
        return  "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api") // json 방식
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String  name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello { // alt + Ins로 제너레이터를 통해 getter setter을 만듦
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

