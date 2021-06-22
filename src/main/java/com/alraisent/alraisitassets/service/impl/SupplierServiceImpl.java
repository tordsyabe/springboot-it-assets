package com.alraisent.alraisitassets.service.impl;

import com.alraisent.alraisitassets.dto.SupplierDto;
import com.alraisent.alraisitassets.entity.Supplier;
import com.alraisent.alraisitassets.mapper.CycleAvoidingMappingContext;
import com.alraisent.alraisitassets.mapper.SupplierMapper;
import com.alraisent.alraisitassets.repository.SupplierRepository;
import com.alraisent.alraisitassets.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SupplierServiceImpl implements SupplierService {


    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public SupplierDto saveSupplier(SupplierDto supplierDto) {

        Supplier newSupplier = supplierMapper.supplierDtoToEntity(supplierDto, new CycleAvoidingMappingContext());

        newSupplier.setSupplierId(UUID.randomUUID().toString());
        newSupplier.setCreatedAt(LocalDateTime.now());
        newSupplier.setUpdatedAt(LocalDateTime.now());

        SupplierDto saveSupplier = supplierMapper.entitySupplierToDto(supplierRepository.save(newSupplier), new CycleAvoidingMappingContext());

        return saveSupplier;
    }

    @Override
    public List<SupplierDto> getSuppliers() {

        List<SupplierDto> supplierDtos = new ArrayList<>();

        supplierRepository.findAll().forEach(supplier -> {
            supplierDtos.add(supplierMapper.entitySupplierToDto(supplier, new CycleAvoidingMappingContext()));
        });

        return supplierDtos;
    }
}
