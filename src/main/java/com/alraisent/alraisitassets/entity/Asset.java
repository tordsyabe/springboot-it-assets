package com.alraisent.alraisitassets.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "assets")
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assetId;

    @Column(nullable = false)
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String serial;

    private String model;

    private String modelNumber;

    private String category;

    private LocalDateTime purchaseDate;

    private String purchaseCost;

    private String supplier;

    private String depreciation;

    private String notes;

    private String location;

    private String label;

}
