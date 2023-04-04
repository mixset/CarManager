package com.carmanager.Client.Port;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;
import org.springframework.data.domain.Page;

public interface PaginateClientAdapterInterface
{
    Page<Client> adapt(Page<ClientEntity> clientList);
}
