package com.alraisent.alraisitassets.dto;

import com.alraisent.alraisitassets.entity.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AssetDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String assetId;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String serial;

    private ModelDto modelDto;

    private LocalDate purchaseDate;

    private float purchaseCost;

    private CategoryDto categoryDto;

    private String supplier;

    private String depreciation;

    private String notes;

    private String location;

    private String label;

}
