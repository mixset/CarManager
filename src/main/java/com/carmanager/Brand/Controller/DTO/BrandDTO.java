package com.carmanager.Brand.Controller.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class BrandDTO
{
    @NotNull
    private String name;
}
