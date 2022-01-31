package com.example.springmondaytask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    private final UserServices userServices;
    private final UserRepository userRepo;

    @Autowired
    public UserController(UserServices userServices, UserRepository userRepo) {
        this.userServices = userServices;
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String hello(){
        return "<h1>Hello, this is a spring security class task</h1>";
    }

    @PostMapping("/register")
    public String signUp(@RequestBody UserModel person){
        UserModel user = userServices.savePersons(person);

        if(user == null){
            return "Email taken, please try another";
        }
        System.out.println(person);
        return "User created with details: "+ person.toString();
    }



}
