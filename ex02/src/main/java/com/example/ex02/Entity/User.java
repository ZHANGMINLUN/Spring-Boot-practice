package com.example.ex02.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private int phonenumber;
    private String email;

    @Transient
    private String confirmPassword;

    public User(){

    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phonenumber +
                ", email='" + email + '\'' +
                '}';
    }
}
