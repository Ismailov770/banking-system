package repository;


import model.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BankRepository {
    private final Map<String, Client> clients = new HashMap<>();

    public void save(Client client) { clients.put(client.getId(), client); }
    public Client findById(String id) { return clients.get(id); }
    public Collection<Client> findAll() { return clients.values(); }
}
