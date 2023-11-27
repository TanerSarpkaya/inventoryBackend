package com.inventory.inventorymanagement.service;

import com.inventory.inventorymanagement.dto.BoltRequestDTO;
import com.inventory.inventorymanagement.dto.BoltResponseDTO;

import java.util.List;

public interface BoltService {

    BoltResponseDTO save(BoltRequestDTO boltRequestDTO);

    List<BoltResponseDTO> getBolts();


    BoltResponseDTO getById(Long id);

    void deleteBoltsById(Long id);
}
