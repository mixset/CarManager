package com.carmanager.Vehicle.Repository;


import com.carmanager.Vehicle.Adapter.Entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepositoryInterface extends JpaRepository<VehicleEntity, UUID>
{
    boolean existsByRegistrationPlate(String registrationPlate);
}
