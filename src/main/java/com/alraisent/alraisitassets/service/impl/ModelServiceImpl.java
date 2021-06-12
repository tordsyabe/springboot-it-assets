package com.alraisent.alraisitassets.service.impl;

import com.alraisent.alraisitassets.dto.ModelDto;
import com.alraisent.alraisitassets.repository.ModelRepository;
import com.alraisent.alraisitassets.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public ModelDto createModel(ModelDto modelDto) {

        return null;
    }
}
