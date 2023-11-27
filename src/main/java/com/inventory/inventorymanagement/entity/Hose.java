package com.inventory.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="hoses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Hose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String thickness;
    @Column(nullable = false)
    private String length;
}
