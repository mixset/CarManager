package com.carmanager.Vehicle.Service;

import com.carmanager.Brand.API.BrandAPI;
import com.carmanager.Vehicle.Adapter.Entity.VehicleEntity;
import com.carmanager.Vehicle.Controller.DTO.VehicleDetailDTO;
import com.carmanager.Vehicle.Domain.Exception.VehicleAlreadyExistsException;
import com.carmanager.Vehicle.Domain.Vehicle;
import com.carmanager.Vehicle.Port.SaveVehicleAdapterInterface;
import com.carmanager.Vehicle.Repository.VehicleRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleManager
{
    @Autowired
    VehicleRepositoryInterface vehicleRepository;

    @Autowired
    SaveVehicleAdapterInterface saveVehicleAdapter;

    @Autowired
    BrandAPI brandAPI;

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

    public boolean existsByUUID(UUID vehicleId)
    {
        return vehicleRepository.existsById(vehicleId);
    }

    public VehicleDetailDTO findById(UUID vehicleId)
    {
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(vehicleId);

        if (vehicle.isPresent()) {
            String brandName = brandAPI.findById(vehicle.get().getBrandId()).getName();
            return new VehicleDetailDTO(brandName, vehicle.get().getRegistrationPlate());

        }

        return new VehicleDetailDTO("", "");
    }
}
