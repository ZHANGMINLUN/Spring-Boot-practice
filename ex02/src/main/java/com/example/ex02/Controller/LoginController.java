package com.example.ex02.Controller;

import com.example.ex02.Entity.User;
import com.example.ex02.Form.UserForm;
import com.example.ex02.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerPage")
    public String registerPage() {
        return "registerPage";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping("/register")
    public String POSTregister(@Valid User user, BindingResult result) {
        if(!user.getPassword().equals(user.getConfirmPassword())){
            result.rejectValue("confirmPassword","Password must be the same","PasswordMismatch");
        }

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println("getField - " + error.getField());
                System.out.println("getDefaultMessage - " + error.getDefaultMessage());
                System.out.println("getCode - " + error.getCode());
            }
            return "registerPage";
        }

        userService.AddUserInformation(user);
        return "redirect:/loginPage";
    }

}
