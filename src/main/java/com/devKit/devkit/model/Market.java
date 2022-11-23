package com.devKit.devkit.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "market")
@Data
public class Market extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "rated")
    private String rated;

    @Column(name = "date")
    private String date;

    @Column(name = "off_price")
    private String offPrice;

    @Column(name = "off_shares")
    private String offShares;

    @Column(name = "listed_date")
    private String listedDate;

    @Column(name = "ticker")
    private String ticker;

}
