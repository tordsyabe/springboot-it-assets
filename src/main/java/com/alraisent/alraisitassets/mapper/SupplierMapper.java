package com.alraisent.alraisitassets.mapper;

import com.alraisent.alraisitassets.dto.ModelDto;
import com.alraisent.alraisitassets.dto.SupplierDto;
import com.alraisent.alraisitassets.entity.Model;
import com.alraisent.alraisitassets.entity.Supplier;
import com.alraisent.alraisitassets.model.request.ModelRequestModel;
import com.alraisent.alraisitassets.model.request.SupplierRequestModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AssetMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SupplierMapper {

    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    @Mapping(target = "assets", source = "supplierDto.assetsDto")
    Supplier supplierDtoToEntity(SupplierDto supplierDto , @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(target = "assetsDto", source = "supplier.assets")
    SupplierDto entitySupplierToDto(Supplier supplier, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    SupplierDto supplierRequestModelToDto(SupplierRequestModel supplierRequestModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
