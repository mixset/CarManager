package com.carmanager.Client.Repository;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientVehiclesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ClientVehicleRepositoryInterface extends JpaRepository<ClientVehiclesEntity, UUID>
{
    boolean existsByVehicleIdAndClientId(UUID vehicleId, UUID clientId);

    @Query("SELECT cv.clientId, cv.vehicleId FROM ClientVehiclesEntity cv WHERE cv.clientId = ?1")
    List<ClientVehiclesEntity> findByClientId(UUID clientId);
}
