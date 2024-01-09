package com.peterndta.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    // request mapping cho leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }
    // request mapping cho admin
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
}
