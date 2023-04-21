package com.carmanager.Brand.Domain.Exception;

public class BrandAlreadyExistsException extends Exception
{
    public BrandAlreadyExistsException(String message)
    {
        super(message);
    }
}
