package com.carmanager.Client.Adapter;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;
import com.carmanager.Client.Port.PaginateClientAdapterInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaginateClientAdapter implements PaginateClientAdapterInterface
{
    @Override
    public Page<Client> adapt(Page<ClientEntity> clientList)
    {
        List<Client> clients = clientList
                .getContent()
                .stream()
                .map(ClientEntityToDomainMapper::map)
                .collect(Collectors.toList());

        return new PageImpl<>(clients, clientList.getPageable(), clientList.getTotalElements());
    }
}
