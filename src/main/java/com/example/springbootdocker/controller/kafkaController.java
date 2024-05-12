package com.example.springbootdocker.controller;

import com.example.springbootdocker.model.Book;
import com.example.springbootdocker.service.BookProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class kafkaController {
    @Value("${kafka.topic.my-topic}")
    String myTopic;
    @Autowired
    private BookProducerService producer;
    @Autowired
    private RedissonClient redissonClient;

    kafkaController(BookProducerService producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public String sendMessageToKafkaTopic() throws JsonProcessingException {
        this.producer.sendMessage(myTopic, new Book(1l, "test mag"));
        return "success";
    }

    @GetMapping("/get")
    public Object getValue() {
        RBucket<Object> testKey = redissonClient.getBucket("kafka");
        return testKey.get();
    }
}
