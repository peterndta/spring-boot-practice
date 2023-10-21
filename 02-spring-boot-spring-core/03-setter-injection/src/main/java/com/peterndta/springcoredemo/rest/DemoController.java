package com.peterndta.springcoredemo.rest;

import com.peterndta.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define private field for dependency
    private Coach myCoach;

    // define a setter for dependency injection
    @Autowired
    public void setMyCoach(Coach myCoach) { // không bị ràng buộc bởi tên func
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDaiyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
