package com.alraisent.alraisitassets.controller;

import com.alraisent.alraisitassets.dto.AssetDto;
import com.alraisent.alraisitassets.mapper.AssetMapper;
import com.alraisent.alraisitassets.model.request.AssetRequestModel;
import com.alraisent.alraisitassets.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LaptopController {

    private final AssetService assetService;
    private final AssetMapper assetMapper;

    @Autowired
    public LaptopController(AssetService assetService, AssetMapper assetMapper) {
        this.assetService = assetService;
        this.assetMapper = assetMapper;
    }

    @GetMapping("/laptop")
    public String laptopPage(Model model) {

        model.addAttribute("titleHeader", "Laptops");
        model.addAttribute("title", "Laptops");

        return "laptop/index";
    }

    @GetMapping("/laptop/create")
    public String createLaptop(Model model) {
        model.addAttribute("assetRequestModel", new AssetRequestModel());
        model.addAttribute("titleHeader", "Create Laptop");
        model.addAttribute("title", "Create");
        return "laptop/create";
    }

    @PostMapping("laptop")
    public String saveLaptop(@Valid AssetRequestModel assetRequestModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titleHeader", "Create Laptop");
            return "laptop/create";
        }

        AssetDto assetDto = assetMapper.assetRequestModelToDto(assetRequestModel);

        assetService.saveAsset(assetDto);

        return "redirect:/laptop";

    }
}
