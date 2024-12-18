
public package com.library.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestParam String email, @RequestParam String password, Model model) {
        if (email.equals("admin@library.com") && password.equals("admin123")) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "login";
        }
    }
} {
    
}
