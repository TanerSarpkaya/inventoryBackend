package com.inventory.inventorymanagement.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BoltRequestDTO {
    private String name;
    private String thickness;
    private String length;
    private String type;
}
