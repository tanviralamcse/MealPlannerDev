package com.example.demo12.controller;

import com.example.demo12.models.Item;
import com.example.demo12.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    ItemController() {
    }

    @GetMapping
    public List<Item> get(){
        return this.itemRepository.findAll();
    }

    @PostMapping("/saveItem")
    public void saveItem(Item item){
        this.itemRepository.save(item);
        this.itemRepository.flush();
    }

    @DeleteMapping("/deleteItem")
    public void deleteItem(Long id){
        this.itemRepository.deleteById(id);
        this.itemRepository.flush();
    }

    @PutMapping("/update")
    public void editItem(Long id, String name, Double quantity, Double price){
        Item item = this.itemRepository.getById(id);
        item.setItem_name(name);
        item.setPrice(price);
        item.setQuantity(quantity);
        this.itemRepository.save(item);
        this.itemRepository.flush();

    }

}
