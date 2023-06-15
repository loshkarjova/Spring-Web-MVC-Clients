package org.example.app.services;
import org.example.app.entities.Client;
import org.example.app.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Transactional
    public List<Client> getClients() {
        return repository.getClients();
    }
    @Transactional
    public void saveClient(Client client) {
        repository.saveClient(client);
    }
    @Transactional
    public Client getClient(int id) {
        return repository.getClient(id);
    }
    @Transactional
    public void deleteClient(int id) {
        repository.deleteClient(id);
    }
}
