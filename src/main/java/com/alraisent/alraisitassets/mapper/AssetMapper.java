package com.alraisent.alraisitassets.mapper;

import com.alraisent.alraisitassets.dto.AssetDto;
import com.alraisent.alraisitassets.entity.Asset;
import com.alraisent.alraisitassets.model.request.AssetRequestModel;
import com.alraisent.alraisitassets.repository.CategoryRepository;
import com.alraisent.alraisitassets.repository.ModelRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ModelRepository.class, ModelMapper.class, CategoryRepository.class, CategoryMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetMapper {

    AssetMapper INSTANCE = Mappers.getMapper(AssetMapper.class);

    @Mapping(target = "model", source = "assetDto.modelDto")
    @Mapping(target = "category", source = "assetDto.categoryDto")
    Asset AssetDtoToEntity(AssetDto assetDto, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(target = "modelDto", source = "asset.model")
    @Mapping(target = "categoryDto", source = "asset.category")
    AssetDto assetEntityToDto(Asset asset, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(target = "modelDto", source = "assetRequestModel.modelId")
    @Mapping(target = "categoryDto", source = "assetRequestModel.categoryId")
    @Mapping(target = "purchaseDate", source = "assetRequestModel.purchaseDate", dateFormat = "yyyy-MM-dd")
    AssetDto assetRequestModelToDto(AssetRequestModel assetRequestModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
