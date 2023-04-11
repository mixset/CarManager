package com.carmanager.Brand.Repository;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepositoryInterface extends JpaRepository<BrandEntity, UUID>
{
    boolean existsByName(String name);
}
