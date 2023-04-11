package com.carmanager.Brand.Port;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import com.carmanager.Brand.Domain.Brand;

public interface SingleBrandAdapterInterface
{
    Brand adapt(BrandEntity brand);
}
