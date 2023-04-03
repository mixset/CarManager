package com.carmanager.Client.Port;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;

public interface UpdateClientAdapterInterface
{
    ClientEntity adapt(Client client, Long id);
}
