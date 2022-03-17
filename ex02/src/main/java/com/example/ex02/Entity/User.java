package com.example.ex02.Entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Data
public class User {

    public static final String PHONE_REG = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String username;

    @NotNull
    @Length(min = 6, message = "unless 6 number")
    private String password;

//    @Pattern(regexp = PHONE_REG, message = "Please enter right number")
    private String phonenumber;

    @Email
    private String email;

    @Transient
    @NotBlank
    private String confirmPassword;

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
