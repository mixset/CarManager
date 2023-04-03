package com.carmanager.Client.Port;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;

public interface SingleClientAdapterInterface
{
    Client adapt(ClientEntity client);
}
