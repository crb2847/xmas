package com.example.xmas.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/hello")
    public String hi(){
        logger.info("YOOYOYOYOOYOYO");
        return "THIS IS EASY";
    }
}
