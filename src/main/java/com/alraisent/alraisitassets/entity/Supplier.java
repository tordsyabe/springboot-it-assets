package com.alraisent.alraisitassets.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "suppliers")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String supplierId;

    @Column(nullable = false)
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String contactPerson;

    private String mobile;

    private String phone;

    private String address;

    private String email;

    private String website;

    @OneToMany(mappedBy = "supplier")
    private List<Asset> assets = new ArrayList<>();
}
