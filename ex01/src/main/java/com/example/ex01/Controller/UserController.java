package com.example.ex01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class UserController {

    @GetMapping("/hello")
    public String sayhello(){
        return "HelloWorld!";
    }

    @GetMapping("/getHTML")
    public String sendHTML(){
        return "book";
    }

    @GetMapping("/getMap")
    @ResponseBody
    public Object sendMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hello");
        map.put("age", 18);
        return map;
    }


}
