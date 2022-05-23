package com.devKit.devkit.controller;

import com.devKit.devkit.model.XUser;
import com.devKit.devkit.repo.EngineRepositoryJPA;
import com.devKit.devkit.repo.UserRepositoryJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
public class DashController {

    private final UserRepositoryJPA userRepositoryJPA;
    private final EngineRepositoryJPA engineRepositoryJPA;

    public DashController(UserRepositoryJPA userRepositoryJPA, EngineRepositoryJPA engineRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.engineRepositoryJPA = engineRepositoryJPA;
    }

    @GetMapping("/dashboard")
    public String mainPage(Model model) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());

        var wallets = engineRepositoryJPA.findByUsersId(xUser.getId());
        String eth = wallets.getWalletETH();

        BigDecimal balance = getBalance(eth);
        Request<?, EthGetCode> history = history(eth);

        String str = history.getMethod();

        System.out.println("basdfe " + str);


        model.addAttribute("str", str);
        model.addAttribute("xUser", xUser);
        model.addAttribute("balance", balance);
        model.addAttribute("eth", eth);

        return "dashboard";
    }

    private static Request<?, EthGetTransactionCount> getHistory(String key) throws IOException {
        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/22d6a5974f25485397c011159543ae95"));
        var history = web3.ethGetTransactionCount(key, DefaultBlockParameterName.LATEST);

        return history;
    }

    private static Request<?, EthGetCode> history(String key) {
        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/22d6a5974f25485397c011159543ae95"));
        EthGetCode ethGetCode = new EthGetCode();

        Request<?, EthGetCode> st = web3.ethGetCode(key, DefaultBlockParameterName.LATEST);
        return st;
    }


    private static BigDecimal getBalance(String key) throws IOException {
        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/22d6a5974f25485397c011159543ae95"));

        EthGetBalance balanceWei = web3.ethGetBalance(key, DefaultBlockParameterName.LATEST).send();
        BigDecimal balanceInEither = Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER);

        return balanceInEither;
    }
}
