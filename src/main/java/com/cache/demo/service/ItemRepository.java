package com.cache.demo.service;

import com.cache.demo.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ItemRepository {
Logger logger = LoggerFactory.getLogger(this.getClass());
    public Item findById( int id){
        logger.info("getting item from repository");
        Item item = new Item();
        item.setId(id);
        item.setName("item1");
        return item;
    }
}
