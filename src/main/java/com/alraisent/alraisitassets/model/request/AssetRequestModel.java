package com.alraisent.alraisitassets.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AssetRequestModel {

    @NotEmpty(message = "Asset name cannot be empty")
    private String name;

    @NotEmpty(message = "Provide a serial number")
    private String serial;

    private String modelId;

    private String purchaseDate;

    private String purchaseCost;

    private String categoryId;

    private String supplierId;

    private String employeeId;

    private String depreciation;

    private String notes;

    private String location;

    private String label;


}
