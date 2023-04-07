package com.carmanager.Brand.Repository;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepositoryInterface extends JpaRepository<BrandEntity, Long>
{
    boolean existsByName(String name);
}
