package com.carmanager.Brand.API;

import com.carmanager.Brand.Adapter.Persistence.Entity.BrandEntity;
import com.carmanager.Brand.Controller.DTO.BrandDTO;
import com.carmanager.Brand.Domain.Brand;
import com.carmanager.Brand.Domain.Exception.BrandAlreadyExistsException;
import com.carmanager.Brand.Service.BrandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BrandAPI
{
    @Autowired
    BrandManager brandManager;

    public void add(BrandDTO BrandDTO)
    {
        Brand Brand = brandManager.createNew();
        Brand.setName(BrandDTO.getName());

        try {
            brandManager.save(Brand);
        } catch (BrandAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public BrandEntity getImplById(Long id)
    {
        try {
            return brandManager.getImplById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
