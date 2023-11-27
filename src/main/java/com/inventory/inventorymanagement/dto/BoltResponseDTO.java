package com.inventory.inventorymanagement.dto;

import lombok.Data;

@Data
public class BoltResponseDTO {
    private long id;
    private String name;
    private String thickness;
    private String length;
    private String type;
}
