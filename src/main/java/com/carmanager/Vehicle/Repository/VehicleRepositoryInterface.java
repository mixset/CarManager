package com.carmanager.Vehicle.Repository;

import com.carmanager.Vehicle.Domain.Entity.Vehicle;

public interface VehicleRepositoryInterface
{
    void save(Vehicle client);

    void delete(Vehicle client);
}
