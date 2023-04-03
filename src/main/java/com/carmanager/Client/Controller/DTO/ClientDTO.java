package com.carmanager.Client.Controller.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTO
{
    @NotNull
    @Size(min=2, max=30)
    private String firstname;

    @NotNull
    @Size(min=2, max=30)
    private String lastname;
}
