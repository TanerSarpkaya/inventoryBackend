package com.inventory.inventorymanagement.controller;

import com.inventory.inventorymanagement.dto.BoltRequestDTO;
import com.inventory.inventorymanagement.dto.BoltResponseDTO;
import com.inventory.inventorymanagement.service.BoltService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bolts")
@RequiredArgsConstructor
public class BoltController {

    private final BoltService boltService;

    @PostMapping()
    public BoltResponseDTO create(@RequestBody BoltRequestDTO boltRequestDTO) {
        return boltService.save(boltRequestDTO);
    }
    @GetMapping()
    public List<BoltResponseDTO> getBolts(){
        return boltService.getBolts();
    }
    @GetMapping("/getById")
    public BoltResponseDTO getById(@RequestParam Long id){
        return boltService.getById(id);
    }
    @DeleteMapping()
    public void deleteBoltsById(@RequestParam Long id){
        boltService.deleteBoltsById(id);
    }
}
