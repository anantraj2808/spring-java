package com.anantraj.section02springcore.common;

import org.springframework.stereotype.Component;

@Component  //This annotation marks the class as a Spring Bean = Class managed by Spring
public class BasketballCoach implements Coach{

    public BasketballCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice dribbling for 10 minutes";
    }
}
