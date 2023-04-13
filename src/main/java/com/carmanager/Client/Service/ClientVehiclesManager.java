package com.carmanager.Client.Service;

import com.carmanager.Client.Adapter.ClientVehicleEntityToDomainMapper;
import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Adapter.Persistance.Entity.ClientVehiclesEntity;
import com.carmanager.Client.Controller.DTO.ClientVehicleDTO;
import com.carmanager.Client.Controller.DTO.ClientVehiclesResponse;
import com.carmanager.Client.Domain.Exception.ClientNotFoundException;
import com.carmanager.Client.Domain.Exception.ClientVehicleAlreadyExists;
import com.carmanager.Client.Domain.Exception.InvalidClientVehicleDataException;
import com.carmanager.Client.Repository.ClientRepositoryInterface;
import com.carmanager.Client.Repository.ClientVehicleRepositoryInterface;
import com.carmanager.Vehicle.API.VehicleAPI;
import com.carmanager.Vehicle.Domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
            ClientVehiclesResponse entry = new ClientVehiclesResponse();
           // entry.setBrandName(clientVehicle.getVehicleId().);
            entry.setRegistrationPlate("test2");

            response.add(entry);
        }

        return response;

/*        return clientVehicleRepository.findByClientId(clientId)
                .stream()
                .map(ClientVehicleEntityToDomainMapper::map)
                .collect(Collectors.toList());*/

    }
}
