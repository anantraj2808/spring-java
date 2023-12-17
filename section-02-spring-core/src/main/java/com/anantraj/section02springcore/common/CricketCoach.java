package com.anantraj.section02springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  //This annotation marks the class as a Spring Bean = Class managed by Spring
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }

    //init method
//    @PostConstruct
//    public void doStartupStuff(){
//        System.out.println("In do startup stuff = " + getClass().getSimpleName());
//    }
//
//    //destroy method
//    @PreDestroy
//    public void doCleanupStuff(){
//        System.out.println("In do cleanup stuff = " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!";
    }
}
