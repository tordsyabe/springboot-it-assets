package com.alraisent.alraisitassets.controller;

import com.alraisent.alraisitassets.dto.AssetDto;
import com.alraisent.alraisitassets.model.request.AssetRequestModel;
import com.alraisent.alraisitassets.service.AssetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LaptopController {

    private final AssetService assetService;

    @Autowired
    public LaptopController(AssetService assetService) {
        this.assetService = assetService;
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
        model.addAttribute("titleHeader", "Laptops");
        model.addAttribute("title", "Create");
        return "laptop/create";
    }

    @PostMapping("laptop")
    public String saveLaptop(@Valid AssetRequestModel assetRequestModel, BindingResult result, Model model) {
        System.out.println(result);
        if (result.hasErrors()) {
            return "laptop/create";
        }

        AssetDto assetDto = new AssetDto();
        BeanUtils.copyProperties(assetRequestModel, assetDto);

        assetDto.setAssetId("asdfsdlfjsldjfj1212");
        assetService.saveAsset(assetDto);

        return "redirect:/laptop";

    }
}
