package com.carmanager.Client.Repository;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientVehiclesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientVehicleRepositoryInterface extends JpaRepository<ClientVehiclesEntity, UUID>
{
    boolean existsByVehicleIdAndClientId(UUID vehicleId, UUID clientId);

    List<ClientVehiclesEntity> findByClientId(UUID clientId);
}
