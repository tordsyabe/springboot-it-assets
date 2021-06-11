package com.alraisent.alraisitassets.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AssetResponseModel {

    private String assetId;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String serial;

    private String model;

    private String modelNumber;

    private LocalDateTime purchaseDate;

    private String purchaseCost;

    private String supplier;

    private String depreciation;

    private String notes;

    private String location;

    private String label;
}
