package com.carmanager.Client.Adapter.Persistance.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public String firstname;

    @Column(nullable = false)
    public String lastname;

    public ClientEntity(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString()
    {
        return firstname.concat(" ").concat(lastname);
    }
}
