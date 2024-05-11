package com.example.springbootdocker.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class BookProducerService {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, Object o) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, o);
        future.whenComplete((res, ex) -> {
            if (ex == null) {
                log.info("produce success");
            } else {
                log.info("produce failed" + ex.getMessage());
            }
        });
    }
}
