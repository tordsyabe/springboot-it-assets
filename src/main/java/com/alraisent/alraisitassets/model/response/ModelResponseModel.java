package com.alraisent.alraisitassets.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelResponseModel {

    private String modelId;

    private String brand;

    private String name;

    private String modelNumber;

    @Override
    public String toString() {
        return "ModelResponseModel{" +
                "modelId='" + modelId + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                '}';
    }
}
