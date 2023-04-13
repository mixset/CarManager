package com.carmanager.Client.Controller.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Data
public class ClientVehiclesResponse
{
    private String brandName;
    private String registrationPlate;
}
