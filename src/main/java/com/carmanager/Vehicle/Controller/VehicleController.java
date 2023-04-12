package com.carmanager.Vehicle.Controller;

import com.carmanager.Vehicle.API.VehicleAPI;
import com.carmanager.Vehicle.Controller.DTO.VehicleDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController
{
    @Autowired
    VehicleAPI vehicleAPI;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody VehicleDTO vehicleDTO)
    {
        vehicleAPI.add(vehicleDTO);
    }
}
