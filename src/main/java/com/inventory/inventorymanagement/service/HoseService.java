package com.inventory.inventorymanagement.service;


import com.inventory.inventorymanagement.dto.BoltResponseDTO;
import com.inventory.inventorymanagement.dto.HoseRequestDTO;
import com.inventory.inventorymanagement.dto.HoseResponseDTO;

import java.util.List;

public interface HoseService {

    HoseResponseDTO save(HoseRequestDTO hoseRequestDTO);

    List<HoseResponseDTO> getHoses();


    BoltResponseDTO getById(Long id);

    void deleteHosesById(Long id);
}
