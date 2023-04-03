package com.carmanager.Vehicle.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Client
{
    private String firstname;
    private String lastname;

    @Override
    public String toString()
    {
        return firstname.concat(" ").concat(lastname);
    }
}


// INF/APP -> wywalić
// Ports/Domain/Adapter/Repo
// Katalogi
/*
* Ports -> komunikacja elementów/interfejsy
*
*
* intefejsy obok repo
* */