package com.nokhacode.userapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test-api")
public class TestController {


    @GetMapping
    public String testApi(){
        log.info("Test api is working");

        return "test api is working fine";
    }
}
