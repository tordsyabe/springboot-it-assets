package com.alraisent.alraisitassets.service.impl;

import com.alraisent.alraisitassets.dto.AssetDto;
import com.alraisent.alraisitassets.entity.Asset;
import com.alraisent.alraisitassets.repository.AssetRepository;
import com.alraisent.alraisitassets.service.AssetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    @Autowired
    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public AssetDto saveAsset(AssetDto assetDto) {

        AssetDto returnValue = new AssetDto();
        Asset newAsset = new Asset();
        BeanUtils.copyProperties(assetDto, newAsset);

        Asset savedAsset = assetRepository.save(newAsset);

        BeanUtils.copyProperties(savedAsset, returnValue);
        return returnValue;
    }
}
