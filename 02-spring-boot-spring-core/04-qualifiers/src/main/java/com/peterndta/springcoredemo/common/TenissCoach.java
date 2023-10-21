package com.peterndta.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenissCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Tennis practice all day";
    }
}
