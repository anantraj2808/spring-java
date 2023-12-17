package com.anantraj.section02springcore.config;

import com.anantraj.section02springcore.common.Coach;
import com.anantraj.section02springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

///For creating SwimCoach = bean without @Component annotation

@Configuration
public class SportsConfig {

    public SportsConfig(){
        System.out.println("In Constructor = " + getClass().getSimpleName());
    }

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
