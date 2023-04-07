package com.carmanager.Brand.Adapter;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import com.carmanager.Brand.Domain.Brand;
import com.carmanager.Brand.Port.SaveBrandAdapterInterface;
import org.springframework.stereotype.Service;

@Service
public class SaveBrandAdapter implements SaveBrandAdapterInterface
{
    @Override
    public BrandEntity adapt(Brand Brand)
    {
        BrandEntity BrandEntity = new BrandEntity();
        BrandEntity.setName(Brand.getName());

        return BrandEntity;
    }
}
