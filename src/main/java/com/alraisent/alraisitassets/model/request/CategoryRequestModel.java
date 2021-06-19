package com.alraisent.alraisitassets.model.request;

import com.alraisent.alraisitassets.enums.AssetType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CategoryRequestModel {

    @NotEmpty(message = "Category name cannot be empty")
    private String name;

    private AssetType assetType;
}
