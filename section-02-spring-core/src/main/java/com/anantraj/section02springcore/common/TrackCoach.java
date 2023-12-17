package com.anantraj.section02springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component  //This annotation marks the class as a Spring Bean = Class managed by Spring
// @Lazy //Lazy Initialization
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!!!";
    }
}
