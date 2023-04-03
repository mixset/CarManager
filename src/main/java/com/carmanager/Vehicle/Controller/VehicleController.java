package com.carmanager.Vehicle.Controller;

import com.carmanager.Vehicle.Domain.Entity.Vehicle;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController
{
    public String add(@RequestBody Vehicle vehicle)
    {
        return "Create vehicle with data " + vehicle.toString();
    }
}
