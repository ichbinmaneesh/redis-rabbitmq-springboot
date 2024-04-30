package com.cache.demo.publisher;

import com.cache.demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.routing.json.key}")
    private String routingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user){
        LOGGER.info(String.format("json message sent -> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,user);
    }
}
