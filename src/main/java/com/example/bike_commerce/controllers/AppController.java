package com.example.bike_commerce.controllers;

import com.example.bike_commerce.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    BikeService bikeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bikes", bikeService.retrieveBikes());

        return "home";
    }

    @GetMapping("/contact-support")
    public String support(Model model) {

        return "customer-support";
    }

//    @GetMapping("/user/delete/{userId}")
//    public String deleteUser(@PathVariable Long userId, Model model) {
//        Optional<Employees> retrievedUser = userService.retrieveAUser(userId) ;
//
////        if (retrievedUser.isPresent()) {
////            userService.deleteAUser(userId);
////        }
//
//        return "redirect:/users";
//    }
}
