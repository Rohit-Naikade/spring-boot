package com.rohit.springcoredemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class cricketCoach implements Coach{

    public cricketCoach(){
        System.out.println("In constructor of: "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!";
    }
}
