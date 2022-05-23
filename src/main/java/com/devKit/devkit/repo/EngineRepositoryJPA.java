package com.devKit.devkit.repo;

import com.devKit.devkit.engine.EngineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepositoryJPA extends JpaRepository<EngineModel, String> {
    EngineModel findByUsersId(String user_id);
}
