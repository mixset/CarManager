package com.carmanager.Client.Repository;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ClientRepositoryInterface extends PagingAndSortingRepository<ClientEntity, Long>, JpaRepository<ClientEntity, Long>
{
/*    void save(ClientEntity client);

    ClientEntity findById(Long clientId);

    void update(ClientEntity client);

    void delete(Long clientId);*/
}
