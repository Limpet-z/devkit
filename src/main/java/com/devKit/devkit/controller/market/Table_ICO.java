package com.devKit.devkit.controller.market;

import com.devKit.devkit.model.Market;
import com.devKit.devkit.repo.MarketRepository;

import java.util.HashMap;
import java.util.Map;

public class Table_ICO {

    private final MarketRepository marketRepository;

    public Table_ICO(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }


    public Map<String, String> getDataBaseResources() {

        Market market = marketRepository.findByStatus("ICO");

        if (market != null) {
            Map<String, String> map = new HashMap<>();

        }

        return null;
    }
}
