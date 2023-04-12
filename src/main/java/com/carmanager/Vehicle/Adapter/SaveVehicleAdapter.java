package com.carmanager.Vehicle.Adapter;

import com.carmanager.Brand.API.BrandAPI;
import com.carmanager.Vehicle.Adapter.Entity.VehicleEntity;
import com.carmanager.Vehicle.Domain.Vehicle;
import com.carmanager.Vehicle.Port.SaveVehicleAdapterInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveVehicleAdapter implements SaveVehicleAdapterInterface
{
    @Autowired
    BrandAPI brandAPI;

    @Override
    public VehicleEntity adapt(Vehicle vehicle)
    {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setRegistrationPlate(vehicle.getRegistrationPlate());
        vehicleEntity.setBrandId(brandAPI.findById(vehicle.getBrandId()).getUuid());

        return vehicleEntity;
    }
}
