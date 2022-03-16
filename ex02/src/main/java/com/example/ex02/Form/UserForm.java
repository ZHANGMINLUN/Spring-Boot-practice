package com.example.ex02.Form;

import com.example.ex02.Entity.User;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


public class UserForm extends User {
    private String confirmPassword;

}
