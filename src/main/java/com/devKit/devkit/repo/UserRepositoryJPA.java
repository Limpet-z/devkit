package com.devKit.devkit.repo;

import com.devKit.devkit.model.XUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<XUser, Integer> {

    XUser findByEmail (String email);


}
