package com.peterndta.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Track Coach run 300 laps";
    }
}
