package com.cache.demo.service;

import com.cache.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Cacheable(value = "itemCache")
    public Item getItemForId(int id){
       return itemRepository.findById(id);
    }

}
