package com.alraisent.alraisitassets.entity;

import com.alraisent.alraisitassets.enums.AssetType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String categoryId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private AssetType assetType;

    @OneToMany(mappedBy = "category")
    private List<Asset> assets = new ArrayList<>();

}
