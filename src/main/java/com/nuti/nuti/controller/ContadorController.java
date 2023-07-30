package com.nuti.nuti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContadorController {
    
    @GetMapping("/")
    public String showForm() {
        return "index";
    }
}
