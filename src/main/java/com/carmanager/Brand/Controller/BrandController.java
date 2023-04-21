package com.carmanager.Brand.Controller;

import com.carmanager.Brand.API.BrandAPI;
import com.carmanager.Brand.API.DTO.BrandCreatedResponseDTO;
import com.carmanager.Brand.Controller.DTO.BrandDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
public class BrandController
{
    @Autowired
    BrandAPI brandAPI;

    @PostMapping("/")
    public ResponseEntity<BrandCreatedResponseDTO> add(@Valid @RequestBody BrandDTO brandDTO)
    {
        BrandCreatedResponseDTO response = brandAPI.add(brandDTO);

        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
