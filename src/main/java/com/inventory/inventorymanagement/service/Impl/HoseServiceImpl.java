package com.inventory.inventorymanagement.service.Impl;

import com.inventory.inventorymanagement.dto.BoltResponseDTO;
import com.inventory.inventorymanagement.dto.HoseRequestDTO;
import com.inventory.inventorymanagement.dto.HoseResponseDTO;
import com.inventory.inventorymanagement.entity.Hose;
import com.inventory.inventorymanagement.exception.RecordAlreadyExist;
import com.inventory.inventorymanagement.exception.RecordNotFound;
import com.inventory.inventorymanagement.repository.HoseRepository;
import com.inventory.inventorymanagement.service.HoseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoseServiceImpl implements HoseService {
    private final ModelMapper modelMapperHose;
    private final HoseRepository hoseRepository;

    public HoseServiceImpl(ModelMapper modelMapperHose, HoseRepository hoseRepository) {
        this.modelMapperHose = modelMapperHose;
        this.hoseRepository = hoseRepository;
    }
    @Override
    public HoseResponseDTO save(HoseRequestDTO hoseRequestDTO) {
        var controlledData = hoseRepository.findByNameAndThickness(hoseRequestDTO.getName(),hoseRequestDTO.getThickness());
        if(controlledData == null){
            Hose hoseEntity = modelMapperHose.map(hoseRequestDTO, Hose.class);
            Hose savedEntity = hoseRepository.save(hoseEntity);
            HoseResponseDTO hoseResponseDTO = modelMapperHose.map(savedEntity, HoseResponseDTO.class);
            return hoseResponseDTO;
        }
        else{
            throw new RecordAlreadyExist();
        }

    }

    @Override
    public List<HoseResponseDTO> getHoses() {
        var hoseAll = hoseRepository.findAll();
        return hoseAll.stream().map(hose -> modelMapperHose.map(hose, HoseResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BoltResponseDTO getById(Long id) {

        return modelMapperHose.map(hoseRepository.findById(id).orElseThrow(() -> new RecordNotFound()), BoltResponseDTO.class);
    }

    @Override
    public void deleteHosesById(Long id) {

    }



}
