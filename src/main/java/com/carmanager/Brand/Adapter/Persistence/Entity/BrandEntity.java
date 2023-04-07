package com.carmanager.Brand.Adapter.Persistence.Entity;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientHasVehicleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class BrandEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClientHasVehicleEntity> clientHasVehicle = new HashSet<>();
}
