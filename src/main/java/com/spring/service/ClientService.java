package com.spring.service;

import com.spring.model.Client;

import java.util.List;
public interface ClientService {

    void save(Client client);
    List<Client> getAll();
    Client getById(Long id);
    void delete(Long id);
    List<Client> search(String string);
}
