package com.carmanager.Brand.API;

import com.carmanager.Brand.Controller.DTO.BrandDTO;
import com.carmanager.Brand.Domain.Brand;
import com.carmanager.Brand.Domain.Exception.BrandAlreadyExistsException;
import com.carmanager.Brand.Service.BrandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class BrandAPI
{
    @Autowired
    BrandManager brandManager;

    public void add(BrandDTO brandDTO)
    {
        Brand brand = brandManager.createNew();
        brand.setName(brandDTO.getName());

        try {
            brandManager.save(brand);
        } catch (BrandAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Brand findById(UUID brandId)
    {
        try {
            return brandManager.findById(brandId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
