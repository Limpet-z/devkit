package com.devKit.devkit.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class XUser extends BaseEntity {

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "erc20")
    private String erc20;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    private LocalDateTime created;
    private LocalDateTime modified;

    @Column(name = "activation_code")
    private String activationCode;


    public XUser() {

        LocalDateTime date = LocalDateTime.now();
        super.id = UUID.randomUUID().toString();
        this.created = date;
        this.modified = date;
    }

    @NotNull
    @NotBlank
    private String description;

    public XUser(String description) {
        this();
        this.description = description;
    }

}