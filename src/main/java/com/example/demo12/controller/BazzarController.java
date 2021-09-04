package com.example.demo12.controller;


import com.example.demo12.models.Bazzar;
import com.example.demo12.models.User;
import com.example.demo12.repository.BazzarRepository;
import com.example.demo12.repository.userrepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/bazzar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BazzarController {
    @Autowired
    private BazzarRepository bazzarRepository;


    BazzarController(){

    }

    @GetMapping
    public List<Bazzar> get(){
        return this.bazzarRepository.findAll();
    }

    @PostMapping("/save")
    public void save(Bazzar bazzar) {
        this.bazzarRepository.save(bazzar);
        this.bazzarRepository.flush();
    }
}
