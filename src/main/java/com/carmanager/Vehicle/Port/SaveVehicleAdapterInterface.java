package com.carmanager.Vehicle.Port;

import com.carmanager.Vehicle.Adapter.Entity.VehicleEntity;
import com.carmanager.Vehicle.Domain.Vehicle;

public interface SaveVehicleAdapterInterface
{
    VehicleEntity adapt(Vehicle vehicle);
}
