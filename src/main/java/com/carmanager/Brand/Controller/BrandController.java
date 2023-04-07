package com.carmanager.Brand.Controller;

import com.carmanager.Brand.API.BrandAPI;
import com.carmanager.Brand.Controller.DTO.BrandDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
public class BrandController
{
    @Autowired
    BrandAPI BrandAPI;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody BrandDTO brandDTO)
    {
        BrandAPI.add(brandDTO);
    }
}
