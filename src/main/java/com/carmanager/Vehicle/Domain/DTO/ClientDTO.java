package com.carmanager.Vehicle.Domain.DTO;

public class ClientDTO
{
    public String firstname;
    public String lastname;

    public ClientDTO(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }
}
