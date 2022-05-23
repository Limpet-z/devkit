package com.devKit.devkit.engine;

import com.devKit.devkit.model.XUser;
import com.devKit.devkit.repo.UserRepositoryJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Transactions {


    private final UserRepositoryJPA userRepositoryJPA;

    public Transactions(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @GetMapping("/transactions")
    public String mainPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());

        model.addAttribute("xUser", xUser);
        return "engine/transactions";
    }
}
