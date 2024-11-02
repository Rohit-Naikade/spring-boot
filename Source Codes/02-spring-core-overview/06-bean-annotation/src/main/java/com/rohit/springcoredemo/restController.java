package com.rohit.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    private Coach myCoach;
    public restController(){
        System.out.println("In Constructor of:"+ this.getClass().getSimpleName());
    }
    @Autowired
    public void setCoach( @Qualifier("createCoach") Coach theCoach){
        myCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
