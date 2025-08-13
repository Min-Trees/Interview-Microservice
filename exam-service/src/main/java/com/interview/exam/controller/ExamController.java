package com.interview.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Exam Service";
    }
}
