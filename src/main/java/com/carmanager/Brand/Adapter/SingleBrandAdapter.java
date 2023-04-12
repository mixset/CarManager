package com.carmanager.Brand.Adapter;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import com.carmanager.Brand.Domain.Brand;
import com.carmanager.Brand.Port.SingleBrandAdapterInterface;
import org.springframework.stereotype.Service;

@Service
public class SingleBrandAdapter implements SingleBrandAdapterInterface
{
    @Override
    public Brand adapt(BrandEntity brandEntity)
    {
        Brand brand = new Brand();
        brand.setUuid(brandEntity.getUuid());
        brand.setName(brandEntity.getName());

        return brand;
    }
}
