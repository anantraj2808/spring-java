package com.anantraj.first_app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World Anant";
    }

    @GetMapping("/anant-raj")
    public String sayAnantRaj(){
        return "Anant Raja Raj";
    }
}
