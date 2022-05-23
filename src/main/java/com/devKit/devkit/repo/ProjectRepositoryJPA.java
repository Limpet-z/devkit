package com.devKit.devkit.repo;

import com.devKit.devkit.controller.create.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositoryJPA extends JpaRepository<Projects, Integer> {

    Projects findByName(String name);
}
