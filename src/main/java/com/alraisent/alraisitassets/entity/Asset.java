package com.alraisent.alraisitassets.entity;

import com.alraisent.alraisitassets.dto.EmployeeDto;
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
    private long id;

    @Column(nullable = false)
    private String assetId;

    @Column(nullable = false)
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String serial;

    @ManyToOne
    private Model model;

    private LocalDate purchaseDate;

    private String purchaseCost;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Supplier supplier;

    private String companyId;

    private String depreciation;

    private String notes;

    private String location;

    private String label;

}
