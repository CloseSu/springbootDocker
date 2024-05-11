package com.example.springbootdocker.service;

import com.example.springbootdocker.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
public class BookConsumerService {
    @Autowired
    private RedissonClient redissonClient;
    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = {"${kafka.topic.my-topic}"}, groupId = "group1")
    public void consumeMessage(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            log.info("ConsumerRecord: " + bookConsumerRecord.value());
            Book book = objectMapper.readValue(bookConsumerRecord.value(), Book.class);
            log.info("comsume topic:{} partition:{}-> {}", bookConsumerRecord.topic(), bookConsumerRecord.partition(), book.toString());
            RBucket<Object> testKey = redissonClient.getBucket("kafka");
            testKey.set(book, Duration.ofMinutes(60));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
