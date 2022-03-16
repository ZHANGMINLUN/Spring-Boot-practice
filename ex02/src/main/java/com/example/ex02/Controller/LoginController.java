package com.example.ex02.Controller;

import com.example.ex02.Entity.User;
import com.example.ex02.Entity.UserRepository;
import com.example.ex02.Form.UserForm;
import com.example.ex02.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerPage")
    public String registerPage(){
        return "registerPage";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "loginPage";
    }

    @PostMapping("/register")
    public String POSTregister(UserForm userForm){
        User user = userForm.convertToUser();
        userService.AddUserInformation(user);
        return "loginPage";
    }

}
