package com.devKit.devkit.controller;

import com.devKit.devkit.model.XUser;
import com.devKit.devkit.repo.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashController {

    private final UserRepository userRepository;

    public DashController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/dashboard")
    public String mainPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepository.findByEmail(user.getUsername());

        model.addAttribute("xUser", xUser);
        return "dashboard";
    }
}
