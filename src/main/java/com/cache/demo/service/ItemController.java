package com.cache.demo.service;

import com.cache.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items/{id}")
    public Item getItemForId(@PathVariable("id") Integer id){
        return itemService.getItemForId(id);
    }
}
