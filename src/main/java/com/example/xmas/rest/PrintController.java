package com.example.xmas.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@RestController
public class PrintController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/print")
    public String print(){
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/hello")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8081"))
                .build();
        try {
            logger.info("Hitting Andrea's web api to print");
            webClient.get().exchange().block();
            logger.info("Finished hitting Andrea's web api to print");
        } catch (Exception e){
            logger.error("Failed to hit Andrea's web api for printing", e);
        }
        return "printing";
    }
}
