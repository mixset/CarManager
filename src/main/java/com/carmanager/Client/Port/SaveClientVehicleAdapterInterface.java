package com.carmanager.Client.Port;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Adapter.Persistance.Entity.ClientVehiclesEntity;

public interface SaveClientVehicleAdapterInterface
{
    ClientVehiclesEntity adapt(ClientEntity client, BrandEntity brand, String registrationPlate);
}
