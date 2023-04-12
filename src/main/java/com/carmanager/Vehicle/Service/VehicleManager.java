package com.carmanager.Vehicle.Service;

import com.carmanager.Vehicle.Domain.Exception.VehicleAlreadyExistsException;
import com.carmanager.Vehicle.Domain.Vehicle;
import com.carmanager.Vehicle.Port.SaveVehicleAdapterInterface;
import com.carmanager.Vehicle.Repository.VehicleRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleManager
{
    @Autowired
    VehicleRepositoryInterface vehicleRepository;

    @Autowired
    SaveVehicleAdapterInterface saveVehicleAdapter;

    public Vehicle createNew()
    {
        return new Vehicle();
    }

    public void save(Vehicle vehicle) throws VehicleAlreadyExistsException
    {
        if (vehicleRepository.existsByRegistrationPlate(vehicle.getRegistrationPlate())) {
            throw new VehicleAlreadyExistsException(
                "Vehicle with registration plate %s already exists".formatted(vehicle.getRegistrationPlate())
            );
        }

        vehicleRepository.save(
            saveVehicleAdapter.adapt(vehicle)
        );
    }
}
