package com.example.demo12.controller;


import com.example.demo12.models.Bazzar;
import com.example.demo12.models.User;
import com.example.demo12.repository.BazzarRepository;
import com.example.demo12.repository.userrepository;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/bazzar")
public class BazzarController {
    @Autowired
    private BazzarRepository bazzarRepository;

    @Autowired
    private userrepository userrepository;


    BazzarController(){

    }

    @GetMapping
    public List<Bazzar> get(){
        return this.bazzarRepository.findAll();
    }

    @PostMapping("/save")
    public Object save(String bazzar_item,Float price,
   Float quantity,String unit, long bazzar_by, String bazzar_date
    ) {
        try {
            Bazzar newBazzar = new Bazzar();
            newBazzar.setBazzar_item(bazzar_item);

            //convert and set bazzar date
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
            DateTime dateTime = DateTime.parse(bazzar_date, formatter);;
            newBazzar.setBazzar_date(dateTime.toDate());

            newBazzar.setPrice(price);
            newBazzar.setQuantity(quantity);
            newBazzar.setUnit(unit);

            newBazzar.setCreate_on(DateTime.now().toDate());
            newBazzar.setUpdated_on(DateTime.now().toDate());

            // set bazzar by
            User bazzarBy = this.userrepository.getById(bazzar_by);
            newBazzar.setUser(bazzarBy);

            this.bazzarRepository.save(newBazzar);
            this.bazzarRepository.flush();


            Object myobj = new Object() {
                public final boolean success = true;
                public final String successMessage = "Saved successfully";
            };
            return  myobj;

        }
        catch (Exception e){
            Object myobj = new Object() {
                public final boolean success = false;
                public final String successMessage = e.getMessage();
            };
            return  myobj;
        }

    }
}
