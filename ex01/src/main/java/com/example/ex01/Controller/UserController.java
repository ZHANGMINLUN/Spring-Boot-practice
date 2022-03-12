package com.example.ex01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class UserController {

    @GetMapping("/hello")
    public String sayhello() {
        return "HelloWorld!";
    }

    @GetMapping("/getHTML")
    public String sendHTML() {
        return "book";
    }

    @GetMapping("/getMap")
    @ResponseBody
    public Object sendMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hello");
        map.put("age", 18);
        return map;
    }

    @GetMapping("/getVariable/{id}_{username:[a-z_]+}")
    @ResponseBody
    public Object getVariableFromUrl(@PathVariable("id") long id, @PathVariable("username") String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("ID", id);
        map.put("USERNAME", username);
        return map;
    }

    @PostMapping("/postInfo")
    @ResponseBody
    public Object getVariableByPOST(@RequestParam("name") String name,
                                    @RequestParam("author") String author,
                                    @RequestParam("isbn") int isbn) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("author", author);
        map.put("isbn", isbn);
        return map;
    }

    @GetMapping("/getVariabl")
    @ResponseBody
    //http://localhost:8080/api/getVariabl?page=5&size=big
    public Object getVariableWithoutUrl(@RequestParam("page") long page,
                                        @RequestParam(value = "size",defaultValue = "yeah") String size) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("size", size);
        return map;
    }

}
