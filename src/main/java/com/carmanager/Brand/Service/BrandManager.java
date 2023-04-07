package com.carmanager.Brand.Service;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import com.carmanager.Brand.Domain.Brand;
import com.carmanager.Brand.Domain.Exception.BrandAlreadyExistsException;
import com.carmanager.Brand.Domain.Exception.BrandNotFoundException;
import com.carmanager.Brand.Port.SaveBrandAdapterInterface;
import com.carmanager.Brand.Repository.BrandRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandManager
{
    @Autowired
    BrandRepositoryInterface brandRepository;

    @Autowired
    SaveBrandAdapterInterface saveBrandAdapter;

    public Brand createNew()
    {
        return new Brand();
    }

    public void save(Brand brand) throws BrandAlreadyExistsException
    {
        if (brandRepository.existsByName(brand.getName())) {
            throw new BrandAlreadyExistsException("Brand %s already exists".formatted(brand.getName()));
        }

        brandRepository.save(
            saveBrandAdapter.adapt(brand)
        );
    }

    public BrandEntity getImplById(Long brandId) throws BrandNotFoundException
    {
        Optional<BrandEntity> entity = brandRepository.findById(brandId);

        if (entity.isEmpty()) {
            throw new BrandNotFoundException("Brand with ID %d not found.".formatted(brandId));
        }

        return entity.get();
    }
}
