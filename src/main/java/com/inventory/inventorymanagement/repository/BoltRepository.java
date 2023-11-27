package com.inventory.inventorymanagement.repository;

import com.inventory.inventorymanagement.entity.Bolt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoltRepository extends JpaRepository<Bolt, Long> {

    Bolt findByNameAndLength(String name, String length);
}
