package com.carmanager.Client.Service;

import com.carmanager.Client.Adapter.Persistance.Entity.ClientEntity;
import com.carmanager.Client.Domain.Client;
import com.carmanager.Client.Domain.Exception.ClientNotFoundException;
import com.carmanager.Client.Port.SaveClientAdapterInterface;
import com.carmanager.Client.Port.SingleClientAdapterInterface;
import com.carmanager.Client.Port.UpdateClientAdapterInterface;
import com.carmanager.Client.Repository.ClientRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager
{
    @Autowired
    ClientRepositoryInterface clientRepository;

    @Autowired
    SaveClientAdapterInterface saveClientAdapter;

    @Autowired
    SingleClientAdapterInterface singleClientAdapter;

    @Autowired
    UpdateClientAdapterInterface updateClientAdapter;

    public Client createNew()
    {
        return new Client();
    }

    public Client findById(Long clientId) throws Exception
    {
        Optional<ClientEntity> entity = Optional.ofNullable(clientRepository.findById(clientId));

        if (entity.isEmpty()) {
            throw new ClientNotFoundException();
        }

        return singleClientAdapter.adapt(entity.get());
    }

    public void delete(Long clientId)
    {
        clientRepository.delete(clientId);
    }

    public void update(Long id, Client client)
    {
        clientRepository.update(
            updateClientAdapter.adapt(client, id)
        );
    }

    public void save(Client client)
    {
        clientRepository.save(
            saveClientAdapter.adapt(client)
        );
    }
}
