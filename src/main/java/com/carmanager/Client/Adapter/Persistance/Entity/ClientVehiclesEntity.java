package com.carmanager.Client.Adapter.Persistance.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "client_vehicles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientVehiclesEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @JoinColumn(name = "client_id")
    private UUID clientId;

    @JoinColumn(name = "vehicle_id")
    private UUID vehicleId;
}
