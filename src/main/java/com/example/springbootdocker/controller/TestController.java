package com.example.springbootdocker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/getTestMsg")
    public String getTestMsg() {
        String msg = "test spring boot success";
        for (int i = 0; i < 30; i++) {
            log.info(msg);
        }
        return msg;
    }
    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(5000);
        return "test spring slow boot success";
    }
}
