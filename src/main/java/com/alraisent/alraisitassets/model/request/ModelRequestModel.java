package com.alraisent.alraisitassets.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class ModelRequestModel {

    @NotEmpty(message = "Brand name cannot be empty")
    private String brand;

    @NotEmpty(message = "Model name cannot be empty")
    private String name;

    private String modelNumber;

}
