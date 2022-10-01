package com.devKit.devkit.controller;

import com.devKit.devkit.model.XUser;
import com.devKit.devkit.repo.EngineRepositoryJPA;
import com.devKit.devkit.repo.UserRepositoryJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthGetCode;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
public class TestDash {

    private final UserRepositoryJPA userRepositoryJPA;
    private final EngineRepositoryJPA engineRepositoryJPA;

    public TestDash(UserRepositoryJPA userRepositoryJPA, EngineRepositoryJPA engineRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.engineRepositoryJPA = engineRepositoryJPA;
    }

    @GetMapping("/test-dashboard")
    public String mainPage(Model model) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());

        var wallets = engineRepositoryJPA.findByUsersId(xUser.getId());
        String eth = wallets.getWalletETH();



        model.addAttribute("xUser", xUser);
        model.addAttribute("eth", eth);

        return "test-dashboard";
    }
}
