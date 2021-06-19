package com.alraisent.alraisitassets.controller;

import com.alraisent.alraisitassets.dto.AssetDto;
import com.alraisent.alraisitassets.mapper.AssetMapper;
import com.alraisent.alraisitassets.mapper.CycleAvoidingMappingContext;
import com.alraisent.alraisitassets.mapper.ModelMapper;
import com.alraisent.alraisitassets.model.request.AssetRequestModel;
import com.alraisent.alraisitassets.model.response.ModelResponseModel;
import com.alraisent.alraisitassets.service.AssetService;
import com.alraisent.alraisitassets.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LaptopController {

    private final AssetService assetService;
    private final AssetMapper assetMapper;
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    @Autowired
    public LaptopController(AssetService assetService, AssetMapper assetMapper, ModelService modelService, ModelMapper modelMapper) {
        this.assetService = assetService;
        this.assetMapper = assetMapper;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/laptop")
    public String laptopPage(Model model) {

        model.addAttribute("titleHeader", "Laptops");
        model.addAttribute("title", "Laptops");

        return "laptop/index";
    }

    @GetMapping("/laptop/create")
    public String createLaptopPage(Model model) {

        List<ModelResponseModel> modelResponseModels = new ArrayList<>();

        modelService.getModels().forEach(modelDto -> {
            modelResponseModels.add(modelMapper.modelDtoToResponse(modelDto, new CycleAvoidingMappingContext()));
        });

        model.addAttribute("assetRequestModel", new AssetRequestModel());
        model.addAttribute("modelResponseModels", modelResponseModels);
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
