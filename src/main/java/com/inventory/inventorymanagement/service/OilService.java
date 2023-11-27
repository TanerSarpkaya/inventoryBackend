package com.inventory.inventorymanagement.service;

import com.inventory.inventorymanagement.dto.BoltResponseDTO;
import com.inventory.inventorymanagement.dto.OilRequestDTO;
import com.inventory.inventorymanagement.dto.OilResponseDTO;

import java.util.List;

public interface OilService {
    OilResponseDTO save(OilRequestDTO oilRequestDTO);

    List<OilResponseDTO> getOils();

    OilResponseDTO getById(Long id);

    void deleteOilsById(Long id);
}
