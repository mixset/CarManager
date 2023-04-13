package com.carmanager.Brand.Adapter.Persistence.Entity;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientVehiclesEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class BrandEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    //@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
   // private Set<ClientVehiclesEntity> clientHasVehicle = new HashSet<>();
}
