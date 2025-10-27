package persistence;

import exceptions.SerializationException;
import model.Client;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StorageManager {
    private final File file = new File("bank_data.ser");

    public void save(Collection<Client> clients) throws SerializationException {
        Map<String, Client> map = new HashMap<>();
        for (Client c : clients) map.put(c.getId(), c);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(map);
        } catch (IOException e) {
            throw new SerializationException("Save failed");
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Client> load() throws SerializationException {
        if (!file.exists()) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<String, Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException("Load failed");
        }
    }
}

