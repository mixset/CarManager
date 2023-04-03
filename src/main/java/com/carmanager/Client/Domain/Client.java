package com.carmanager.Client.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
