package com.carmanager.Client.API;

import com.carmanager.Client.Controller.DTO.ClientDTO;
import com.carmanager.Client.Controller.DTO.ClientVehicleDTO;
import com.carmanager.Client.Controller.DTO.ClientVehiclesResponse;
import com.carmanager.Client.Domain.Client;
import com.carmanager.Client.Domain.Exception.ClientNotFoundException;
import com.carmanager.Client.Domain.Exception.ClientVehicleAlreadyExists;
import com.carmanager.Client.Domain.Exception.InvalidClientVehicleDataException;
import com.carmanager.Client.Service.ClientManager;
import com.carmanager.Client.Service.ClientVehiclesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ClientAPI
{
    @Autowired
    ClientManager clientManager;

    @Autowired
    ClientVehiclesManager clientVehiclesManager;

    public Client findById(UUID id)
    {
        try {
            return clientManager.findById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void delete(UUID id)
    {
        try {
            clientManager.delete(id);
        } catch (ClientNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void update(UUID clientId, ClientDTO clientDTO)
    {
        Client client = clientManager.createNew();
        client.setFirstname(clientDTO.getFirstname());
        client.setLastname(clientDTO.getLastname());

        try {
            clientManager.update(clientId, client);
        } catch (ClientNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Page<Client> paginate(Pageable pageable)
    {
        return clientManager.paginate(pageable);
    }

    public List<ClientVehiclesResponse> getClientVehicles(UUID clientId)
    {
         return clientVehiclesManager.getClientVehicles(clientId);
    }

    public void add(ClientDTO clientDTO)
    {
        Client client = clientManager.createNew();
        client.setFirstname(clientDTO.getFirstname());
        client.setLastname(clientDTO.getLastname());

        clientManager.save(client);
    }

    public void addVehicleToClient(ClientVehicleDTO clientVehicleDTO)
    {
        try {
            clientVehiclesManager.assignVehicleToClient(clientVehicleDTO);
        } catch (ClientVehicleAlreadyExists | InvalidClientVehicleDataException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid data provided.");
        }
    }
}
