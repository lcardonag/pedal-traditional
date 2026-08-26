package redhat.engineering.ebikes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redhat.engineering.ebikes.services.BikeService;

@Controller
public class AppController {
    private final BikeService bikeService;

    public AppController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bikes", bikeService.getBikes());
        return "home";
    }

    @GetMapping("/customer-support")
    public String customerSupport(Model model) {
        return "customer-support";
    }
}
