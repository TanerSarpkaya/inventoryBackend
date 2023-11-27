package com.inventory.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bolts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bolt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String thickness;
    @Column(nullable = false)
    private String length;
    @Column(nullable = false)
    private String type;
}
