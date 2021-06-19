package com.alraisent.alraisitassets.controller;

import com.alraisent.alraisitassets.dto.CategoryDto;
import com.alraisent.alraisitassets.mapper.CategoryMapper;
import com.alraisent.alraisitassets.mapper.CycleAvoidingMappingContext;
import com.alraisent.alraisitassets.model.request.CategoryRequestModel;
import com.alraisent.alraisitassets.model.response.CategoryResponseModel;
import com.alraisent.alraisitassets.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/category")
    public String categoryPage(Model model) {

        List<CategoryResponseModel> categoryResponseModels = new ArrayList<>();

        categoryService.getCategories().forEach(categoryDto -> {
            categoryResponseModels.add(categoryMapper.modelDtoResponse(categoryDto, new CycleAvoidingMappingContext()));
        });

        model.addAttribute("categories", categoryResponseModels);
        model.addAttribute("titleHeader", "Categories");
        model.addAttribute("title", "Categories");
        return "category/index";
    }

    @GetMapping("/category/create")
    public String createCategoryPage(Model model) {

        model.addAttribute("categoryRequestModel", new CategoryRequestModel());
        model.addAttribute("titleHeader", "Create Category");
        model.addAttribute("title", "Create Category");
        return "category/create";
    }

    @PostMapping("/category")
    public String saveCategory(@Valid CategoryRequestModel categoryRequestModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titleHeader", "Create Category");
            return "category/create";
        }

        CategoryDto categoryDto = categoryMapper.categoryRequestModelToDto(categoryRequestModel, new CycleAvoidingMappingContext());

        categoryService.saveCategory(categoryDto);

        return "redirect:/category";

    }
}
