package com.carmanager.Client.API;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Controller.DTO.ClientDTO;
import com.carmanager.Client.Domain.Client;
import com.carmanager.Client.Domain.Exception.ClientNotFoundException;
import com.carmanager.Client.Service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientAPI
{
    @Autowired
    UserManager userManager;

    public Client findById(Long id)
    {
        try {
            return userManager.findById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void delete(Long id)
    {
        userManager.delete(id);
    }

    public void update(Long id, ClientDTO clientDTO)
    {
        Client client = userManager.createNew();
        client.setFirstname(clientDTO.getFirstname());
        client.setLastname(clientDTO.getLastname());

        try {
            userManager.update(id, client);
        } catch (ClientNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Page<Client> paginate(Pageable pageable)
    {
        return userManager.paginate(pageable);
    }

    public String getClientVehicles(Long id)
    {
        return "Get vehicles by client id " + id;
    }

    public void add(ClientDTO clientDTO)
    {
        Client client = userManager.createNew();
        client.setFirstname(clientDTO.getFirstname());
        client.setLastname(clientDTO.getLastname());

        userManager.save(client);
    }
}
