package com.alraisent.alraisitassets.mapper;

import com.alraisent.alraisitassets.dto.CategoryDto;
import com.alraisent.alraisitassets.entity.Category;
import com.alraisent.alraisitassets.model.request.CategoryRequestModel;
import com.alraisent.alraisitassets.model.response.CategoryResponseModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AssetMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "assets", source = "categoryDto.assetsDto")
    Category categoryDtoToEntity(CategoryDto categoryDto, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(target = "assetsDto", source = "category.assets")
    CategoryDto categoryEntityToDto(Category category, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    CategoryDto categoryRequestModelToDto(CategoryRequestModel categoryRequestModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    CategoryResponseModel modelDtoResponse(CategoryDto categoryDto, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
