package com.carmanager.Client.Adapter;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;
import com.carmanager.Client.Port.UpdateClientAdapterInterface;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateClientAdapter implements UpdateClientAdapterInterface
{
    @Override
    public ClientEntity adapt(Client client, UUID id)
    {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setUuid(id);
        clientEntity.setFirstname(client.getFirstname());
        clientEntity.setLastname(client.getLastname());

        return clientEntity;
    }
}
