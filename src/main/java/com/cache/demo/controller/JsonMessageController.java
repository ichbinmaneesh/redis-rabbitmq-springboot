package com.cache.demo.controller;

import com.cache.demo.dto.User;
import com.cache.demo.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public JsonMessageController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendMessage(user);
        return ResponseEntity.ok("json message sent to RabbitMQ...");
    }
}
