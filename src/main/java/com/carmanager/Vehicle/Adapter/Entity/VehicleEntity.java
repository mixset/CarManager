package com.carmanager.Vehicle.Adapter.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "vehicle")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @JoinColumn(name = "brand_id")
    private UUID brandId;

    @Column(nullable = false)
    private String registrationPlate;
}
