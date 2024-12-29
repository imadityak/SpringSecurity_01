package com.imadityak.springBootSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Session ID: " + request.getSession().getId();
    }
}