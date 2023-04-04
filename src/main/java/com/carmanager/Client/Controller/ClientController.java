package com.carmanager.Client.Controller;

import com.carmanager.Client.API.ClientAPI;
import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Controller.DTO.ClientDTO;
import com.carmanager.Client.Domain.Client;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController
{
    @Autowired
    ClientAPI clientAPI;

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id)
    {
        return clientAPI.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody ClientDTO client)
    {
        clientAPI.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        clientAPI.delete(id);
    }

    @GetMapping("/paginate")
    public Page<Client> paginate(@PageableDefault() Pageable pageable)
    {
        return clientAPI.paginate(pageable);
    }

    @GetMapping("/{id}/vehicles")
    public String getClientVehicles(@PathVariable Long id)
    {
        return clientAPI.getClientVehicles(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody ClientDTO clientDTO)
    {
        clientAPI.add(clientDTO);
    }
}
