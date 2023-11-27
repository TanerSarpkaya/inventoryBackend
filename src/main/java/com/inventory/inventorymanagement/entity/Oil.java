package com.inventory.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "oils")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Oil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
}
