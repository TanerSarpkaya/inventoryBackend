package com.inventory.inventorymanagement.controller;

import com.inventory.inventorymanagement.dto.BoltResponseDTO;
import com.inventory.inventorymanagement.dto.OilRequestDTO;
import com.inventory.inventorymanagement.dto.OilResponseDTO;
import com.inventory.inventorymanagement.service.OilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oils")
@RequiredArgsConstructor
public class OilController {
    private final OilService oilService;
    @PostMapping()
    public OilResponseDTO create(@RequestBody OilRequestDTO oilRequestDTO) {
        return oilService.save(oilRequestDTO);
    }

    @GetMapping()
    public List<OilResponseDTO> getOils(){
        return oilService.getOils();
    }
    @GetMapping("/getById")
    public OilResponseDTO getById(@RequestParam Long id){
        return oilService.getById(id);
    }
    @DeleteMapping()
    public void deleteBoltsById(@RequestParam Long id){
        oilService.deleteOilsById(id);
    }
}
