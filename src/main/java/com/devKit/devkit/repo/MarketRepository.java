package com.devKit.devkit.repo;

import com.devKit.devkit.engine.EngineModel;
import com.devKit.devkit.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, String> {

    Market findByStatus(String status);
}
