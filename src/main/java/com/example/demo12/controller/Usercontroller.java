package com.example.demo12.controller;

import com.example.demo12.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo12.repository.userrepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class Usercontroller {

    @Autowired
    private userrepository userRepository;

    public Usercontroller(){
    }

    @GetMapping
    public List<User> get(){
        return this.userRepository.findAll();
    }

    @PostMapping("/saveUser")
    public void save(User user){
        this.userRepository.save(user);
        this.userRepository.flush();
    }
}
