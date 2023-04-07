package com.carmanager.Brand.Port;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import com.carmanager.Brand.Domain.Brand;

public interface SaveBrandAdapterInterface
{
    BrandEntity adapt(Brand Brand);
}
