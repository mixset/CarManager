package com.carmanager.Vehicle.Domain.Exception;

public class VehicleAlreadyExistsException extends Exception
{
    public VehicleAlreadyExistsException(String message) {
        super(message);
    }
}
