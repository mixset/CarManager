package com.carmanager.Vehicle.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Vehicle
{
    private String model;
    private String registrationPlate;

    public String toString()
    {
        return model.concat(" ").concat(registrationPlate);
    }
}
