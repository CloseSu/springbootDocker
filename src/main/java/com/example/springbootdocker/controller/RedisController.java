package com.example.springbootdocker.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/setValue")
    public String setValue() {
        double random = Math.random();
        RBucket<Object> testKey = redissonClient.getBucket("testKey");
        testKey.set("aaa" + random, Duration.ofMinutes(10));
        return "success";
    }

    @GetMapping("/getValue")
    public Object getValue() {
        RBucket<Object> testKey = redissonClient.getBucket("testKey");
        return testKey.get();
    }
}
