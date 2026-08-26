package com.example.bike_commerce.controllers;

import com.example.bike_commerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/dashboard/orders")
    public String allOrders(Model model) {
        model.addAttribute("orders", orderService.retrieveOrders());

        return "/order/orders";
    }
}
