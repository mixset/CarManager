package com.carmanager.Client.Repository;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ClientRepositoryInterface extends PagingAndSortingRepository<ClientEntity, UUID>, JpaRepository<ClientEntity, UUID>
{
}
