package com.rohit.springcoredemo;

public class swimCoach implements Coach{

    public Coach swimCoach(){
        System.out.println("In constructor of:"+getClass().getSimpleName());
        return new swimCoach();
    }

    @Override
    public String getDailyWorkout() {
        return "swim for 1000 mtrs as a warmup";
    }
}
