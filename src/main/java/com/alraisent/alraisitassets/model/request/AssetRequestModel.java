package com.alraisent.alraisitassets.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class AssetRequestModel {

    @NotEmpty(message = "Asset name cannot be empty")
    @Size(min = 5, max = 250, message = "Asset name must be between 5 and 250")
    private String name;

    @NotEmpty(message = "Provide a serial number")
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
