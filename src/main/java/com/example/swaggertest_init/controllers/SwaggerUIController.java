package com.example.swaggertest_init.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerUIController {
    @GetMapping("/docs")
    public String swaggerUI(){
        return "redirect:/swagger-ui/index.html?url=/v3/api-docs/";
    }

}
