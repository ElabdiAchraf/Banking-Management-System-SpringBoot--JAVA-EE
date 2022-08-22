package com.example.tp14.services;

import com.example.tp14.entities.Client;
import com.example.tp14.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client c) {
        return clientRepository.save(c);
    }



    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientByCode(long code) {
        return clientRepository.findByCodeClient(code);
    }


}
