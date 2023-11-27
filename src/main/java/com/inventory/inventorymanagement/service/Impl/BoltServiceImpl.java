package com.inventory.inventorymanagement.service.Impl;

import com.inventory.inventorymanagement.dto.BoltRequestDTO;
import com.inventory.inventorymanagement.dto.BoltResponseDTO;
import com.inventory.inventorymanagement.entity.Bolt;
import com.inventory.inventorymanagement.exception.RecordAlreadyExist;
import com.inventory.inventorymanagement.exception.RecordNotFound;
import com.inventory.inventorymanagement.repository.BoltRepository;
import com.inventory.inventorymanagement.service.BoltService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoltServiceImpl implements BoltService {

    private final ModelMapper modelMapperOil;
    private final BoltRepository boltRepository;

    public BoltServiceImpl(ModelMapper modelMapper, BoltRepository boltRepository) {
        this.modelMapperOil = modelMapper;
        this.boltRepository = boltRepository;
    }


    @Override
    public BoltResponseDTO save(BoltRequestDTO boltRequestDTO) {
        var controlledData = boltRepository.findByNameAndLength(boltRequestDTO.getName(),boltRequestDTO.getLength());
        if(controlledData == null){
            Bolt boltEntity = modelMapperOil.map(boltRequestDTO, Bolt.class);
            Bolt savedEntity = boltRepository.save(boltEntity);
            BoltResponseDTO boltResponseDTO = modelMapperOil.map(savedEntity, BoltResponseDTO.class);
            return boltResponseDTO;
        }
        else{
            throw new RecordAlreadyExist();
        }

    }

    @Override
    public List<BoltResponseDTO> getBolts() {
        var boltAll = boltRepository.findAll();
        return boltAll.stream().map(bolt -> modelMapperOil.map(bolt, BoltResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BoltResponseDTO getById(Long id) {

        return modelMapperOil.map(boltRepository.findById(id).orElseThrow(() -> new RecordNotFound()), BoltResponseDTO.class);
    }

    @Override
    public void deleteBoltsById(Long id) {
        boltRepository.deleteById(id);
    }

}
