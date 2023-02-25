package com.soc.sosb.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring";
    }

    @GetMapping("/greet/{name}")
    public String greet_pathvariable(@PathVariable String name) {
        return "hello " + name + " !";
    }

    @GetMapping("/greet")
    public String greet_reqparam(@RequestParam("name") String name) {
        return "hello " + name + " !";
    }

    @GetMapping("/resttemplate") //sample resttemplate call
    public String getresttemplace() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestJson = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        String responseBody = response.getBody();
        return responseBody;
    }


}
