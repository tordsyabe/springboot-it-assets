package com.alraisent.alraisitassets.service.impl;

import com.alraisent.alraisitassets.dto.ModelDto;
import com.alraisent.alraisitassets.entity.Model;
import com.alraisent.alraisitassets.mapper.ModelMapper;
import com.alraisent.alraisitassets.repository.ModelRepository;
import com.alraisent.alraisitassets.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelDto saveModel(ModelDto modelDto) {

        Model newModel =  modelMapper.modelDtoToEntity(modelDto);
        newModel.setModelId(UUID.randomUUID().toString());
        newModel.setCreatedAt(LocalDateTime.now());
        newModel.setUpdatedAt(LocalDateTime.now());

        ModelDto savedModel = modelMapper.entityModelToDto(modelRepository.save(newModel));

        return savedModel;
    }
}
