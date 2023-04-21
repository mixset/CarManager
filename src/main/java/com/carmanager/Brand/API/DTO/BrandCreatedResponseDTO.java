package com.carmanager.Brand.API.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class BrandCreatedResponseDTO
{
    private Integer status;
    private UUID uuid;
    private String name;
}
