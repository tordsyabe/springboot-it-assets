package com.alraisent.alraisitassets.service;

import com.alraisent.alraisitassets.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto saveSupplier(SupplierDto supplierDto);

    List<SupplierDto> getSuppliers();
}
