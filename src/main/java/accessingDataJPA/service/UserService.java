package accessingDataJPA.service;

import accessingDataJPA.model.Client;

public interface UserService {
    void save(Client client);

    Client getClientByLogin(String username);
}