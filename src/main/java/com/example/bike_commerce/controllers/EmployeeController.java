package com.example.bike_commerce.controllers;

import com.example.bike_commerce.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeesService employeesService;

    @GetMapping("/employees/login")
    public String login(Model model) {

        return "auth/employee-login";
    }

    @PostMapping("/employees/login")
    public String postLoginData(Model model) {
        return "redirect:/";
    }
}

