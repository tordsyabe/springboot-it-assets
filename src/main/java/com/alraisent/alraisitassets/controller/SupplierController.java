package com.alraisent.alraisitassets.controller;

import com.alraisent.alraisitassets.dto.ModelDto;
import com.alraisent.alraisitassets.dto.SupplierDto;
import com.alraisent.alraisitassets.mapper.CycleAvoidingMappingContext;
import com.alraisent.alraisitassets.mapper.SupplierMapper;
import com.alraisent.alraisitassets.model.request.ModelRequestModel;
import com.alraisent.alraisitassets.model.request.SupplierRequestModel;
import com.alraisent.alraisitassets.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SupplierController {

    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;

    @Autowired
    public SupplierController(SupplierService supplierService, SupplierMapper supplierMapper) {
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
    }

    @GetMapping("/supplier")
    public String supplierPage(Model model) {

        model.addAttribute("titleHeader", "Suppliers");
        model.addAttribute("title", "Suppliers");
        return "supplier/index";
    }

    @GetMapping("/supplier/create")
    public String createSupplierPage(Model model) {

        model.addAttribute("supplierRequestModel", new SupplierRequestModel());
        model.addAttribute("titleHeader", "Create Supplier");
        model.addAttribute("title", "Create Supplier");
        return "supplier/create";
    }

    @PostMapping("/supplier")
    public String saveSupplier(@Valid SupplierRequestModel supplierRequestModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titleHeader", "Create Supplier");
            return "supplier/create";
        }

        SupplierDto supplierDto = supplierMapper.supplierRequestModelToDto(supplierRequestModel, new CycleAvoidingMappingContext());

        supplierService.saveSupplier(supplierDto);

        return "redirect:/supplier";

    }
}
