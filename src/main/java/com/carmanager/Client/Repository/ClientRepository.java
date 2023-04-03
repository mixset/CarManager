package com.carmanager.Client.Repository;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class ClientRepository implements ClientRepositoryInterface
{
    @Autowired
    EntityManager entityManager;

    @Override
    public void save(ClientEntity client)
    {
        entityManager.persist(client);
    }

    @Override
    public ClientEntity findById(Long clientId)
    {
        return entityManager.find(ClientEntity.class, clientId);
    }

    @Override
    public void update(ClientEntity client)
    {
        entityManager.merge(client);
    }

    @Override
    public void delete(Long clientId)
    {
        ClientEntity row = entityManager.find(ClientEntity.class, clientId);
        entityManager.remove(row);
    }
}
