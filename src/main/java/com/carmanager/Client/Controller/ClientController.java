package com.carmanager.Client.Controller;

import com.carmanager.Client.API.ClientAPI;
import com.carmanager.Client.Controller.DTO.ClientDTO;
import com.carmanager.Client.Controller.DTO.ClientVehicleDTO;
import com.carmanager.Client.Controller.DTO.ClientVehiclesResponse;
import com.carmanager.Client.Domain.Client;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController
{
    @Autowired
    ClientAPI clientAPI;

    @GetMapping("/{id}")
    public Client findById(@PathVariable UUID id)
    {
        return clientAPI.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @Valid @RequestBody ClientDTO client)
    {
        clientAPI.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id)
    {
        clientAPI.delete(id);
    }

    @GetMapping("/paginate")
    public Page<Client> paginate(@PageableDefault() Pageable pageable)
    {
        return clientAPI.paginate(pageable);
    }

    @GetMapping("/{id}/vehicles")
    public List<ClientVehiclesResponse> getClientVehicles(@PathVariable UUID id)
    {
        return clientAPI.getClientVehicles(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody ClientDTO clientDTO)
    {
        clientAPI.add(clientDTO);
    }

    @PostMapping("/add-vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public void addVehicleToClient(@Valid @RequestBody ClientVehicleDTO clientVehicleDTO)
    {
        clientAPI.addVehicleToClient(clientVehicleDTO);
    }
}
