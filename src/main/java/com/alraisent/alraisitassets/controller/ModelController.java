package com.alraisent.alraisitassets.controller;

import com.alraisent.alraisitassets.dto.ModelDto;
import com.alraisent.alraisitassets.mapper.ModelMapper;
import com.alraisent.alraisitassets.model.request.ModelRequestModel;
import com.alraisent.alraisitassets.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ModelController {

    private final ModelService modelService;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelController(ModelService modelService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/model")
    public String modelPage(Model model) {

        model.addAttribute("titleHeader", "Models");
        model.addAttribute("title", "Models");
        return "model/index";
    }

    @GetMapping("/model/create")
    public String createModelPage(Model model) {

        model.addAttribute("modelRequestModel", new ModelRequestModel());
        model.addAttribute("titleHeader", "Create Model");
        model.addAttribute("title", "Create Model");
        return "model/create";
    }

    @PostMapping("/model")
    public String saveModel(@Valid ModelRequestModel modelRequestModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titleHeader", "Create Model");
            return "model/create";
        }

        ModelDto modelDto = modelMapper.modelRequestModelToDto(modelRequestModel);

        modelService.saveModel(modelDto);

        return "redirect:/model";

    }
}
