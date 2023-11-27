package com.inventory.inventorymanagement.controller;

import com.inventory.inventorymanagement.dto.BoltResponseDTO;
import com.inventory.inventorymanagement.dto.HoseRequestDTO;
import com.inventory.inventorymanagement.dto.HoseResponseDTO;
import com.inventory.inventorymanagement.service.HoseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hoses")
@RequiredArgsConstructor
public class HoseController {
    private final HoseService hoseService;

    @PostMapping()
    public HoseResponseDTO create(@RequestBody HoseRequestDTO hoseRequestDTO) {
        return hoseService.save(hoseRequestDTO);
    }
    @GetMapping()
    public List<HoseResponseDTO> getHoses(){
        return hoseService.getHoses();
    }
    @GetMapping("/getById")
    public BoltResponseDTO getById(@RequestParam Long id){
        return hoseService.getById(id);
    }
    @DeleteMapping()
    public void deleteBoltsById(@RequestParam Long id){
        hoseService.deleteHosesById(id);
    }


}
