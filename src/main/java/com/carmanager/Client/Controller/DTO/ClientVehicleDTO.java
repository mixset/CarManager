package com.carmanager.Client.Controller.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ClientVehicleDTO
{
    @NotNull
    private UUID clientId;

    @NotNull
    private UUID vehicleId;
}
