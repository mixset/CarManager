package com.carmanager.Brand.Domain.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BrandAlreadyExistsException extends Exception
{
    public BrandAlreadyExistsException(String message)
    {
        super(message);
    }
}
