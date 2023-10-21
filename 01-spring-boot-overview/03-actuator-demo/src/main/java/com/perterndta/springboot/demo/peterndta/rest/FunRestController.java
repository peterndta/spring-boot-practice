package com.perterndta.springboot.demo.peterndta.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
//     expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard ";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day";
    }
}
