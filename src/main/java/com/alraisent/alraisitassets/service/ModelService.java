package com.alraisent.alraisitassets.service;

import com.alraisent.alraisitassets.dto.ModelDto;

import java.util.List;

public interface ModelService {

    ModelDto saveModel(ModelDto modelDto);
    List<ModelDto> getModels();
}
