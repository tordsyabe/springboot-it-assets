package com.alraisent.alraisitassets.dto;

import com.alraisent.alraisitassets.enums.AssetType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String categoryId;

    private String name;

    private AssetType assetType;

    private List<AssetDto> assetsDto = new ArrayList<>();
}
