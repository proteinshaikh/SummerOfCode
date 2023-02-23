package com.soc.sosb.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

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


}
