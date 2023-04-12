package com.carmanager.Vehicle.Controller.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Setter
@Getter
@Data
public class VehicleDTO
{
    @NotNull
    private UUID brandId;

    @NotNull
    @Length(min=8, max=8)
    private String registrationPlate;
}
