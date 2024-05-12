package com.example.springbootdocker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private ObjectMapper objectMapper = new ObjectMapper();
    public void sendMessage(String topic, Object o) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(o);
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, json);
        future.whenComplete((res, ex) -> {
            if (ex == null) {
                log.info("produce success");
            } else {
                log.info("produce failed" + ex.getMessage());
            }
        });
    }
}
