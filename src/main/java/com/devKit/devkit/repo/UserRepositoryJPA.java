package com.devKit.devkit.repo;

import com.devKit.devkit.model.XUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<XUser, String> {

    XUser findByEmail (String email);


    XUser findByActivationCode(String code);
}
