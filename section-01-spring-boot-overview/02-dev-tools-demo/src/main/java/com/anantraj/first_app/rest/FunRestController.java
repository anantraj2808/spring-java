package com.anantraj.first_app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //Method to use injected properties
    @GetMapping("/teamInfo")
    public String teamInfo(){
        return "Coach: " + coachName + " and Team: " + teamName;
    }




    @GetMapping("/")
    public String sayHello(){
        return "Hello World Anant";
    }

    @GetMapping("/anant-raj")
    public String sayAnantRaj(){
        return "Anant Raj Raj";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 10k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is a good day";
    }
}
