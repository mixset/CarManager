package com.carmanager.Brand.Controller.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandDTO
{
    @NotNull
    private String name;
}
