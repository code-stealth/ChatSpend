package com.chatspend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String home() {
        System.out.println("This should appear on the console");
        return "DevTools is working again!";
    }
}
