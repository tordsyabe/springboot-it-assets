package com.alraisent.alraisitassets.dto;

import com.alraisent.alraisitassets.entity.Asset;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ModelDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String modelId;

    private String brand;

    private String name;

    private String modelNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<AssetDto> assetsDto = new ArrayList<>();
}
