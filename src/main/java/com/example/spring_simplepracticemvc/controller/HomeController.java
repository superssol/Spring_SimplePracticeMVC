package com.example.spring_simplepracticemvc.controller;

import com.example.spring_simplepracticemvc.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Home() {
        return "home";
    }


}
