package com.inventory.inventorymanagement.repository;


import com.inventory.inventorymanagement.entity.Oil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OilRepository extends JpaRepository<Oil, Long> {
    Oil findByNameAndBrand(String name, String brand);
}
