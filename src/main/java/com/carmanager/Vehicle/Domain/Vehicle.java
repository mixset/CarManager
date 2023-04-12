package com.carmanager.Vehicle.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle
{
    private UUID uuid;
    private UUID brandId;
    private String registrationPlate;
}
