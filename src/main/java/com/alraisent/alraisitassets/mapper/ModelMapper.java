package com.alraisent.alraisitassets.mapper;

import com.alraisent.alraisitassets.dto.ModelDto;
import com.alraisent.alraisitassets.entity.Model;
import com.alraisent.alraisitassets.model.request.ModelRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AssetMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "assets", source = "modelDto.assetsDto")
    Model modelDtoToEntity(ModelDto modelDto);

    @Mapping(target = "assetsDto", source = "model.assets")
    ModelDto entityModelToDto(Model model);

    ModelDto modelRequestModelToDto(ModelRequestModel modelRequestModel);

}
