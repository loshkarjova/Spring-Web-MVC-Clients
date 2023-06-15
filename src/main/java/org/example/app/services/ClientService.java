package org.example.app.services;
import org.example.app.entities.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClients();
    void saveClient(Client client);
    Client getClient(int id);
    void deleteClient(int id);
}
