package com.example.springbootdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/getTestMsg")
    public String getTestMsg() {
        return "test spring boot success";
    }
    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(50000);
        return "test spring boot success";
    }
}
