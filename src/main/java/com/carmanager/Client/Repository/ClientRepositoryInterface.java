package com.carmanager.Client.Repository;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;

import java.util.Optional;

public interface ClientRepositoryInterface
{
    void save(ClientEntity client);

    ClientEntity findById(Long clientId);

    void update(ClientEntity client);

    void delete(Long clientId);
}
