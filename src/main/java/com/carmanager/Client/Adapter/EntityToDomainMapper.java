package com.carmanager.Client.Adapter;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;
import org.springframework.stereotype.Service;

@Service
public class EntityToDomainMapper
{
    public static Client map(ClientEntity clientEntity)
    {
        Client client = new Client();
        client.setFirstname(clientEntity.getFirstname());
        client.setLastname(clientEntity.getLastname());

        return client;
    }
}
