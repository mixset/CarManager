package com.carmanager.Client.Service;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;
import com.carmanager.Client.Domain.Exception.ClientNotFoundException;
import com.carmanager.Client.Port.PaginateClientAdapterInterface;
import com.carmanager.Client.Port.SaveClientAdapterInterface;
import com.carmanager.Client.Port.SingleClientAdapterInterface;
import com.carmanager.Client.Port.UpdateClientAdapterInterface;
import com.carmanager.Client.Repository.ClientRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientManager
{
    @Autowired
    ClientRepositoryInterface clientRepository;

    @Autowired
    SaveClientAdapterInterface saveClientAdapter;

    @Autowired
    SingleClientAdapterInterface singleClientAdapter;

    @Autowired
    UpdateClientAdapterInterface updateClientAdapter;

    @Autowired
    PaginateClientAdapterInterface paginateClientAdapter;

    public Client createNew()
    {
        return new Client();
    }

    public Client findById(UUID clientId) throws ClientNotFoundException
    {
        Optional<ClientEntity> entity = clientRepository.findById(clientId);

        if (entity.isEmpty()) {
            throw new ClientNotFoundException("Client with ID %s not found.".formatted(clientId));
        }

        return singleClientAdapter.adapt(entity.get());
    }

    public void delete(UUID clientId) throws ClientNotFoundException
    {
        if (!clientRepository.existsById(clientId)) {
            throw new ClientNotFoundException("Client with ID %s not found.".formatted(clientId));
        }

        clientRepository.deleteById(clientId);
    }

    public void update(UUID clientId, Client client) throws ClientNotFoundException
    {
        Optional<ClientEntity> entity = clientRepository.findById(clientId);

        if (entity.isEmpty()) {
            throw new ClientNotFoundException("Client with ID %s not found.".formatted(clientId));
        }

        clientRepository.save(
            updateClientAdapter.adapt(client, clientId)
        );
    }

    public void save(Client client)
    {
        clientRepository.save(
            saveClientAdapter.adapt(client)
        );
    }

    public Page<Client> paginate(Pageable pageable)
    {
        return paginateClientAdapter.adapt(
            clientRepository.findAll(pageable)
        );
    }
}
