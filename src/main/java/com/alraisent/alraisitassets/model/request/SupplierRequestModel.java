package com.alraisent.alraisitassets.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class SupplierRequestModel {

    @NotEmpty(message = "Supplier name cannot be empty")
    private String name;

    private String contactPerson;

    private String mobile;

    private String phone;

    private String address;

    private String email;

    private String website;
}
