package com.anantraj.section02springcore.rest;

import com.anantraj.section02springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    //Constructor Injection
    @Autowired //tells spring to inject a dependency
    public DemoController(@Qualifier("aquatic") Coach coach){
        System.out.println("In Constructor : " + getClass().getSimpleName());
        myCoach = coach;
    }

//    //Setter Injection
//    @Autowired
//    public void setCoach(Coach coach){
//        myCoach = coach;
//    }


    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
