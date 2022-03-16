package com.example.ex02.Controller;

import com.example.ex02.Entity.User;
import com.example.ex02.Entity.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private UserRepository userRepository;

    @GetMapping("/registerPage")
    public String registerPage(){
        return "registerPage";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "loginPage";
    }





    @PostMapping("/register")
    public String POSTregister(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               @RequestParam Integer phonenumber){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhonenumber(phonenumber);
        userRepository.save(user);

        return "loginPage";
    }

}
