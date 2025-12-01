package com.revature.ExpenseReport.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class Hello{
    @GetMapping("/hello")
    String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return "Hello %s!".formatted(name);
    }
}

