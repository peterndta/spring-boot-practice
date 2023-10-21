package com.peterndta.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenissCoach implements Coach {
    public TenissCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis practice all day";
    }
}
