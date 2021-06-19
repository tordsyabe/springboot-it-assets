package com.alraisent.alraisitassets.service.impl;

import com.alraisent.alraisitassets.dto.CategoryDto;
import com.alraisent.alraisitassets.entity.Category;
import com.alraisent.alraisitassets.mapper.CategoryMapper;
import com.alraisent.alraisitassets.mapper.CycleAvoidingMappingContext;
import com.alraisent.alraisitassets.repository.CategoryRepository;
import com.alraisent.alraisitassets.service.CategoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {

        Category newCategory = categoryMapper.categoryDtoToEntity(categoryDto, new CycleAvoidingMappingContext());

        newCategory.setCategoryId(UUID.randomUUID().toString());
        newCategory.setCreatedAt(LocalDateTime.now());
        newCategory.setUpdatedAt(LocalDateTime.now());

        Category savedCategory = categoryRepository.save(newCategory);

        CategoryDto returnValue = categoryMapper.categoryEntityToDto(savedCategory, new CycleAvoidingMappingContext());

        return returnValue;
    }

    @Override
    public List<CategoryDto> getCategories() {

        List<CategoryDto> categoryDtos = new ArrayList<>();

        categoryRepository.findAll().forEach(category -> {
            categoryDtos.add(categoryMapper.categoryEntityToDto(category, new CycleAvoidingMappingContext()));
        });
        return categoryDtos;
    }
}
