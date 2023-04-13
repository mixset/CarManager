package com.carmanager.Client.Port;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;

import java.util.UUID;

public interface UpdateClientAdapterInterface
{
    ClientEntity adapt(Client client, UUID id);
}
