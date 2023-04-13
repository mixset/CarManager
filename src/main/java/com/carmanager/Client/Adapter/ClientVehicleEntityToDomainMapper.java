package com.carmanager.Client.Adapter;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientVehiclesEntity;
import com.carmanager.Client.Controller.DTO.ClientVehiclesResponse;
import com.carmanager.Vehicle.API.VehicleAPI;
import com.carmanager.Vehicle.Domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientVehicleEntityToDomainMapper
{

    public static ClientVehiclesResponse map(ClientVehiclesEntity clientHasVehicle)
    {
        ClientVehiclesResponse response = new ClientVehiclesResponse();

        response.setRegistrationPlate("asd");
        response.setBrandName("asd");


        return response;
    }
}
