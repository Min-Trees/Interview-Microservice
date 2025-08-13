package com.interview.career.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/career")
public class CareerController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Career Service";
    }
}
