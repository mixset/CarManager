package com.carmanager.Client.Adapter;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;
import com.carmanager.Client.Port.SaveClientAdapterInterface;
import org.springframework.stereotype.Service;

@Service
public class SaveClientAdapter implements SaveClientAdapterInterface
{
    @Override
    public ClientEntity adapt(Client client)
    {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstname(client.getFirstname());
        clientEntity.setLastname(client.getLastname());

        return clientEntity;
    }
}
