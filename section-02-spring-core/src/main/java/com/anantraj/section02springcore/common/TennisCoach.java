package com.anantraj.section02springcore.common;
import org.springframework.stereotype.Component;

@Component  //This annotation marks the class as a Spring Bean = Class managed by Spring
//@Primary //Primary Bean
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley!!";
    }
}
