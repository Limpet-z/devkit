package com.devKit.devkit.controller.create;

import com.devKit.devkit.model.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "projects")
public class Projects extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "offeringprice")
    private BigDecimal offeringPrice;

    @Column(name = "offeringshares")
    private BigDecimal offeringShares;

    @Column(name = "marketcap")
    private BigDecimal marketCap;

    @Column(name = "important")
    private String important;

    @Column(name = "title")
    private String title;

    @Column(name = "about")
    private String about;
}
