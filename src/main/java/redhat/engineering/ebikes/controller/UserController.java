package redhat.engineering.ebikes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redhat.engineering.ebikes.config.UserInfoUserDetails;
import redhat.engineering.ebikes.entities.Order;
import redhat.engineering.ebikes.entities.Service_User;
import redhat.engineering.ebikes.repositories.OrderRepository;
import redhat.engineering.ebikes.services.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;
    private final OrderRepository orderRepository;

    @Autowired
    public UserController(UserService userService, OrderRepository orderRepository) {
        this.userService = userService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String postLoginData(Model model) {
        return "redirect:/dashboard";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("service_user", new Service_User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute Service_User serviceUser, Model model) {
        model.addAttribute("service_user", serviceUser);
        userService.createUser(serviceUser);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard/users")
    public String customers(Model model) {
        model.addAttribute("service_users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable Long userId, Model model) {
        userService.deleteAUser(userId);
        return "redirect:/users";
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserInfoUserDetails user, Model model) {
        List<Order> orders = orderRepository.findOrdersByUserId(user.getId());
        model.addAttribute("orders", orders);
        return "profile";
    }
}
