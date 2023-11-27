package com.inventory.inventorymanagement.repository;

import com.inventory.inventorymanagement.entity.Hose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoseRepository extends JpaRepository<Hose, Long> {
    Hose findByNameAndThickness(String name, String thickness);
}
