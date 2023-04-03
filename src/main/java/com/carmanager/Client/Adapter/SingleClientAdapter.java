package com.carmanager.Client.Adapter;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;
import com.carmanager.Client.Port.SingleClientAdapterInterface;
import org.springframework.stereotype.Service;

@Service
public class SingleClientAdapter implements SingleClientAdapterInterface
{
    @Override
    public Client adapt(ClientEntity clientEntity)
    {
        Client client = new Client();
        client.setFirstname(clientEntity.getFirstname());
        client.setLastname(clientEntity.getLastname());

        return client;
    }
}
