package com.devKit.devkit.engine;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreatePortfolio {

    @GetMapping("/create-portfolio")
    private String createPortfolio(Model model) {
        return "create-portfolio";
    }
}
