package com.inventory.inventorymanagement.service.Impl;

import com.inventory.inventorymanagement.dto.BoltRequestDTO;
import com.inventory.inventorymanagement.dto.BoltResponseDTO;
import com.inventory.inventorymanagement.dto.OilRequestDTO;
import com.inventory.inventorymanagement.dto.OilResponseDTO;
import com.inventory.inventorymanagement.entity.Bolt;
import com.inventory.inventorymanagement.entity.Oil;
import com.inventory.inventorymanagement.exception.RecordAlreadyExist;
import com.inventory.inventorymanagement.exception.RecordNotFound;
import com.inventory.inventorymanagement.repository.OilRepository;
import com.inventory.inventorymanagement.service.OilService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OilServiceImpl implements OilService {
    private final ModelMapper modelMapper;

    private final OilRepository oilRepository;

    public OilServiceImpl(ModelMapper modelMapper, OilRepository oilRepository) {
        this.modelMapper = modelMapper;
        this.oilRepository = oilRepository;
    }
    @Override
    public OilResponseDTO save(OilRequestDTO oilRequestDTO) {
        var controlledData = oilRepository.findByNameAndBrand(oilRequestDTO.getName(),oilRequestDTO.getBrand());
        if(controlledData == null){
            Oil oilEntity = modelMapper.map(oilRequestDTO, Oil.class);
            Oil savedEntity = oilRepository.save(oilEntity);
            OilResponseDTO oilResponseDTO = modelMapper.map(savedEntity, OilResponseDTO.class);
            return oilResponseDTO;
        }
        else{
            throw new RecordAlreadyExist();
        }

    }
    @Override
    public List<OilResponseDTO> getOils() {
        var oilAll = oilRepository.findAll();
        return oilAll.stream().map(oil -> modelMapper.map(oil, OilResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OilResponseDTO getById(Long id) {

        return modelMapper.map(oilRepository.findById(id).orElseThrow(() -> new RecordNotFound()), OilResponseDTO.class);
    }
    @Override
    public void deleteOilsById(Long id) {
        oilRepository.deleteById(id);
    }
}
