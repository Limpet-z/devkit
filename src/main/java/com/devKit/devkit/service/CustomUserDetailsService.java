package com.devKit.devkit.service;

import com.devKit.devkit.model.XUser;
import com.devKit.devkit.repo.UserRepositoryJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepositoryJPA userRepositoryJPA;

    public CustomUserDetailsService(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        XUser xUser = userRepositoryJPA.findByEmail(email);

        if (xUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + email);
        }

        UserDetails user;
        user = User.builder()
                .username(xUser.getEmail())
                .password(xUser.getPassword())
                .roles(xUser.getRole())
                .build();
        return user;
    }
}
