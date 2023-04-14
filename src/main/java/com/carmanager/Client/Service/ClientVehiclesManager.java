package com.carmanager.Client.Service;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Adapter.Persistance.Entity.ClientVehiclesEntity;
import com.carmanager.Client.Controller.DTO.ClientVehicleDTO;
import com.carmanager.Client.Controller.DTO.ClientVehiclesResponse;
import com.carmanager.Client.Domain.Exception.ClientVehicleAlreadyExists;
import com.carmanager.Client.Domain.Exception.InvalidClientVehicleDataException;
import com.carmanager.Client.Repository.ClientRepositoryInterface;
import com.carmanager.Client.Repository.ClientVehicleRepositoryInterface;
import com.carmanager.Vehicle.API.VehicleAPI;
import com.carmanager.Vehicle.Controller.DTO.VehicleDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientVehiclesManager
{
    @Autowired
    ClientRepositoryInterface clientRepository;

    @Autowired
    ClientVehicleRepositoryInterface clientVehicleRepository;

    @Autowired
    VehicleAPI vehicleAPI;

    public void assignVehicleToClient(ClientVehicleDTO clientVehicleDTO) throws
        InvalidClientVehicleDataException,
        ClientVehicleAlreadyExists
    {
        Optional<ClientEntity> clientEntity = clientRepository.findById(clientVehicleDTO.getClientId());
        boolean vehicleExists = vehicleAPI.existsByUUID(clientVehicleDTO.getVehicleId());

        if (!vehicleExists || clientEntity.isEmpty()) {
            throw new InvalidClientVehicleDataException("Invalid data provided.");
        }

        if (clientVehicleRepository.existsByVehicleIdAndClientId(
            clientVehicleDTO.getVehicleId(),
            clientVehicleDTO.getClientId()
        )) {
            throw new ClientVehicleAlreadyExists("Given vehicle already exists for specified client.");
        }

          ClientVehiclesEntity clientVehiclesEntity = new ClientVehiclesEntity();
          clientVehiclesEntity.setClientId(clientVehicleDTO.getClientId());
          clientVehiclesEntity.setVehicleId(clientVehicleDTO.getVehicleId());

          clientVehicleRepository.save(clientVehiclesEntity);
    }

    public List<ClientVehiclesResponse> getClientVehicles(UUID clientId)
    {
        List<ClientVehiclesEntity> clientVehicles = clientVehicleRepository.findByClientId(clientId);
        List<ClientVehiclesResponse> response = new ArrayList<>();

        for (ClientVehiclesEntity clientVehicle : clientVehicles) {
            VehicleDetailDTO result = vehicleAPI.findById(clientVehicle.getVehicleId());

            ClientVehiclesResponse entry = new ClientVehiclesResponse();
            entry.setBrandName(result.getBrandName());
            entry.setRegistrationPlate(result.getRegistrationPlate());

            response.add(entry);
        }

        return response;
    }
}
