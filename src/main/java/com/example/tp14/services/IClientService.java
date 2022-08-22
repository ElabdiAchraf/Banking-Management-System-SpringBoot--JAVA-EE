package com.example.tp14.services;

import com.example.tp14.entities.Client;

import java.util.List;

public interface IClientService {
    public Client saveClient (Client c);

    public List<Client> listClient ();
    public Client  findClientByCode(long code);


}
