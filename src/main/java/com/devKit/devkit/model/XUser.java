package com.devKit.devkit.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class XUser {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}