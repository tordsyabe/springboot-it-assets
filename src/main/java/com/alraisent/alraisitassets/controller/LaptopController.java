package com.alraisent.alraisitassets.controller;

import com.alraisent.alraisitassets.dto.AssetDto;
import com.alraisent.alraisitassets.dto.CompanyDto;
import com.alraisent.alraisitassets.mapper.*;
import com.alraisent.alraisitassets.model.request.AssetRequestModel;
import com.alraisent.alraisitassets.model.response.CategoryResponseModel;
import com.alraisent.alraisitassets.model.response.ModelResponseModel;
import com.alraisent.alraisitassets.model.response.SupplierResponseModel;
import com.alraisent.alraisitassets.service.*;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LaptopController {

    private final AssetService assetService;
    private final AssetMapper assetMapper;
    private final ModelService modelService;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;
    private final CompanyService companyService;

    @Autowired
    public LaptopController(AssetService assetService, AssetMapper assetMapper, ModelService modelService, CategoryMapper categoryMapper, ModelMapper modelMapper, CategoryService categoryService, SupplierService supplierService, SupplierMapper supplierMapper, EmployeeService employeeService, CompanyService companyService) {
        this.assetService = assetService;
        this.assetMapper = assetMapper;
        this.modelService = modelService;
        this.categoryMapper = categoryMapper;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
        this.companyService = companyService;
    }

    @GetMapping("/laptop")
    public String laptopPage(Model model) {

        model.addAttribute("titleHeader", "Laptops");
        model.addAttribute("title", "Laptops");

        return "laptop/index";
    }

    @GetMapping("/laptop/create")
    public String createLaptopPage(Model model) throws MalformedURLException, XmlRpcException {

        List<ModelResponseModel> modelResponseModels = new ArrayList<>();
        List<CategoryResponseModel> categoryResponseModels = new ArrayList<>();
        List<SupplierResponseModel> supplierResponseModels = new ArrayList<>();
        List<Map<String, CompanyDto>> companiesDto = new ArrayList<>();

        modelService.getModels().forEach(modelDto -> {
            modelResponseModels.add(modelMapper.modelDtoToResponse(modelDto, new CycleAvoidingMappingContext()));
        });

        categoryService.getCategories().forEach(categoryDto -> {
            categoryResponseModels.add(categoryMapper.modelDtoResponse(categoryDto, new CycleAvoidingMappingContext()));
        });

        supplierService.getSuppliers().forEach(supplierDto -> {
            supplierResponseModels.add(supplierMapper.supplierDtoToResponse(supplierDto, new CycleAvoidingMappingContext()));
        });

        companyService.getCompanies().forEach(companyDto -> {
            companiesDto.add(companyDto);
        });



        model.addAttribute("assetRequestModel", new AssetRequestModel());
        model.addAttribute("modelResponseModels", modelResponseModels);
        model.addAttribute("categoryResponseModels", categoryResponseModels);
        model.addAttribute("supplierResponseModels", supplierResponseModels);
        model.addAttribute("companiesDto", companiesDto);
        model.addAttribute("titleHeader", "Create Laptop");
        model.addAttribute("title", "Create Laptop");
        return "laptop/create";
    }

    @PostMapping("laptop")
    public String saveLaptop(@Valid AssetRequestModel assetRequestModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ModelResponseModel> modelResponseModels = new ArrayList<>();

            modelService.getModels().forEach(modelDto -> {
                modelResponseModels.add(modelMapper.modelDtoToResponse(modelDto, new CycleAvoidingMappingContext()));
            });

            model.addAttribute("modelResponseModels", modelResponseModels);
            model.addAttribute("titleHeader", "Create Laptop");
            model.addAttribute("title", "Create Laptop");
            return "laptop/create";
        }
        AssetDto assetDto = assetMapper.assetRequestModelToDto(assetRequestModel, new CycleAvoidingMappingContext());

        assetService.saveAsset(assetDto);

        return "redirect:/laptop";

    }
}
