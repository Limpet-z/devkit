package com.devKit.devkit.model;

import lombok.Data;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Id
    protected String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
