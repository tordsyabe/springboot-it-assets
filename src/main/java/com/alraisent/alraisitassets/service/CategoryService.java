package com.alraisent.alraisitassets.service;

import com.alraisent.alraisitassets.dto.CategoryDto;

import java.util.List;


public interface CategoryService {

    CategoryDto saveCategory(CategoryDto categoryDto);
    List<CategoryDto> getCategories();
}
