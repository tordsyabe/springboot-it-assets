package com.alraisent.alraisitassets.dto;

import com.alraisent.alraisitassets.entity.Asset;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeDto {

    private int id;

    private String name;

    @OneToMany(mappedBy = "employee")
    private List<Asset> assets = new ArrayList<>();
}
