package com.alraisent.alraisitassets.model.response;

import com.alraisent.alraisitassets.enums.AssetType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CategoryResponseModel {

    private String categoryId;

    private String name;

    private AssetType assetType;

}
