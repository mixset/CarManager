package com.carmanager.Vehicle.API;

import com.carmanager.Vehicle.Controller.DTO.VehicleDTO;
import com.carmanager.Vehicle.Domain.Exception.VehicleAlreadyExistsException;
import com.carmanager.Vehicle.Domain.Vehicle;
import com.carmanager.Vehicle.Service.VehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class VehicleAPI
{
    @Autowired
    VehicleManager vehicleManager;

    public boolean existsByUUID(UUID vehicleId)
    {
        return vehicleManager.existsByUUID(vehicleId);
    }

    public void add(VehicleDTO vehicleDTO)
    {
        Vehicle vehicle = vehicleManager.createNew();
        vehicle.setRegistrationPlate(vehicleDTO.getRegistrationPlate());
        vehicle.setBrandId(vehicleDTO.getBrandId());

        try {
            vehicleManager.save(vehicle);
        } catch (VehicleAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
