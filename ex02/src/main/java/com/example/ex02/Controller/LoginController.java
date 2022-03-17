package com.example.ex02.Controller;

import com.example.ex02.Entity.User;
import com.example.ex02.Service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerPage")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "registerPage";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping("/register")
    public String POSTregister(@Valid User user, BindingResult result, Model model) {

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "Password must be the same", "PasswordMismatch");
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
