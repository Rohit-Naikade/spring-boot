package com.rohit.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice baseball";
    }
}
