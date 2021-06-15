package com.alraisent.alraisitassets.mapper;

import com.alraisent.alraisitassets.dto.AssetDto;
import com.alraisent.alraisitassets.entity.Asset;
import com.alraisent.alraisitassets.model.request.AssetRequestModel;
import com.alraisent.alraisitassets.repository.ModelRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ModelRepository.class, ModelMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetMapper {

    AssetMapper INSTANCE = Mappers.getMapper(AssetMapper.class);

    @Mapping(target = "model", source = "assetDto.modelDto")
    Asset AssetDtoToEntity(AssetDto assetDto);

    @Mapping(target = "modelDto", source = "asset.model")
    AssetDto assetEntityToDto(Asset asset);

    @Mapping(target = "modelDto", source = "assetRequestModel.modelId")
    @Mapping(target = "purchaseDate", source = "assetRequestModel.purchaseDate", dateFormat = "yyyy-MM-dd hh:mm:ss")
    AssetDto assetRequestModelToDto(AssetRequestModel assetRequestModel);
}
