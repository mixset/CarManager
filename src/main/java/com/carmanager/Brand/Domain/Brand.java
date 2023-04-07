package com.carmanager.Brand.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Brand
{
    private String name;

    public String toString()
    {
        return name;
    }
}
