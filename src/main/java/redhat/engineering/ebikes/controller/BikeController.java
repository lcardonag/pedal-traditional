package redhat.engineering.ebikes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redhat.engineering.ebikes.entities.Bike;
import redhat.engineering.ebikes.services.BikeService;

import java.util.Optional;

@Controller
public class BikeController {
    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("bikes", bikeService.getBikes());
        return "dashboard";
    }

    @GetMapping("dashboard/bike/purchase")
    public String purchase(@RequestParam Long bikeId, Model model) {
        Optional<Bike> retrievedBike = bikeService.getBike(bikeId);

        if (retrievedBike.isPresent()) {
            model.addAttribute("bike", retrievedBike.get());
            return "purchase";
        }

        return "redirect:/dashboard";
    }

    @PostMapping("/purchase/{bikeId}")
    public String submitPurchase(@PathVariable Long bikeId , Model model) {
        Optional<Bike> retrievedBike = bikeService.getBike(bikeId);

        if (retrievedBike.isPresent()) {
            model.addAttribute("bike", retrievedBike);
            bikeService.purchaseBike(retrievedBike);
            return "home";
        }

        return "redirect:/home";
    }

    @PostMapping("/create-bike")
    public String postBikeAd(@ModelAttribute Bike bikeData, Model model) {
        bikeService.createBikeAd(bikeData);

        return "redirect:/dashboard";
    }

    @GetMapping("dashboard/bike/create-bike")
    public String createBike(Model model) {
        model.addAttribute("bike", new Bike());
        return "create-bike";
    }

    @GetMapping("dashboard/bike/edit")
    public String updateBike(@RequestParam Long id, Model model) {
        Optional<Bike> retrievedBike = bikeService.getBike(id);

        if (retrievedBike.isPresent()) {
            model.addAttribute("bike_form", new Bike());
            model.addAttribute("bike", retrievedBike.get());
            return "update-bike";
        }

        return "redirect:/dashboard";
    }

    @PostMapping("/bike/update")
    public String submitBikeUpdateForm(@RequestParam Long id, Model model) {
        Optional<Bike> retrievedBike = bikeService.getBike(id);

        if (retrievedBike.isPresent()) {
            model.addAttribute("bike", retrievedBike.get());
            return "update-bike";
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/bike/delete/{bikeId}")
    public String deleteBike(@PathVariable Long bikeId) {
        Optional<Bike> singleBike = bikeService.getBike(bikeId);
        singleBike.ifPresent(bike -> bikeService.deleteBike((Long) bike.getId()));

        return "redirect:/dashboard";
    }
}