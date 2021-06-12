package com.alraisent.alraisitassets.service.impl;

import com.alraisent.alraisitassets.dto.AssetDto;
import com.alraisent.alraisitassets.entity.Asset;
import com.alraisent.alraisitassets.mapper.AssetMapper;
import com.alraisent.alraisitassets.repository.AssetRepository;
import com.alraisent.alraisitassets.service.AssetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Autowired
    public AssetServiceImpl(AssetRepository assetRepository, AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }

    @Override
    public AssetDto saveAsset(AssetDto assetDto) {

        Asset newAsset = assetMapper.AssetDtoToEntity(assetDto);

        newAsset.setAssetId(UUID.randomUUID().toString());
        newAsset.setCreatedAt(LocalDateTime.now());

        Asset savedAsset = assetRepository.save(newAsset);

        AssetDto returnValue = assetMapper.assetEntityToDto(savedAsset);

        return returnValue;
    }
}
