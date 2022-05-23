package com.devKit.devkit.service;

import com.devKit.devkit.mail.MailSender;
import com.devKit.devkit.model.Status;
import com.devKit.devkit.model.XUser;
import com.devKit.devkit.repo.UserRepositoryJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepositoryJPA userRepositoryJPA;
    private final MailSender mailSender;

    public CustomUserDetailsService(UserRepositoryJPA userRepositoryJPA, MailSender mailSender) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.mailSender = mailSender;
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

    public boolean addUser(XUser user) {

        XUser xUser = userRepositoryJPA.findByEmail(user.getEmail());

        if (xUser != null) {
            return false;
        }
        Random random = new Random();
        long x = random.nextLong();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encPass = encoder.encode(user.getPassword());
        user.setName(user.getName());
        user.setPassword(encPass);
        user.setEmail(user.getEmail());
        user.setStatus(Status.ACTIVE);
        user.setRole("USER");
        user.setId(String.valueOf(x));

        user.setActivationCode(UUID.randomUUID().toString());
        userRepositoryJPA.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {

            String message = String.format("Hello, %s! \n" + "Welcome to LIMPET. Please, visit next kink: http://localhost:8080/activate/%s",
                    user.getName(),
                    user.getActivationCode()
                    );

            mailSender.send(user.getEmail(), "Activation Code", message);
        }
        return true;
    }

    public boolean activateUser(String code) {

        XUser xUser =  userRepositoryJPA.findByActivationCode(code);

        if (xUser == null) {
            return false;
        }

        xUser.setActivationCode(null);
        userRepositoryJPA.save(xUser);
        return true;
    }
}
