package com.example.demo12.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity(name = "bazzar")
public class Bazzar implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bazzar_id;

    private String bazzar_item;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    private Float price;

    private Float quantity;

    private String unit;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Date bazzar_date;

    private  Date create_on;

    private  Date updated_on;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;




    public Bazzar(){
    }


    public int getBazzar_id() {
        return bazzar_id;
    }

    public void setBazzar_id(int bazzar_id) {
        this.bazzar_id = bazzar_id;
    }

    public String getBazzar_item() {
        return bazzar_item;
    }

    public void setBazzar_item(String bazzar_item) {
        this.bazzar_item = bazzar_item;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Date getBazzar_date() {
        return bazzar_date;
    }

    public void setBazzar_date(Date bazzar_date) {
        this.bazzar_date = bazzar_date;
    }

    public Date getCreate_on() {
        return create_on;
    }

    public void setCreate_on(Date create_on) {
        this.create_on = create_on;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }

}
