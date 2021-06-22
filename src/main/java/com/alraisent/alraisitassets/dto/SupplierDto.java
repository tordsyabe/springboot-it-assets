package com.alraisent.alraisitassets.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SupplierDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String supplierId;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String contactPerson;

    private String mobile;

    private String phone;

    private String address;

    private String email;

    private String website;

    private List<AssetDto> assetsDto = new ArrayList<>();
}
