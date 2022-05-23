package com.devKit.devkit.engine;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "enginemodel")
public class EngineModel implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "users_id")
    private String usersId;

    @Column(name = "walleteth")
    private String walletETH;

    @Column(name = "walletbtc")
    private String walletBTC;


}
