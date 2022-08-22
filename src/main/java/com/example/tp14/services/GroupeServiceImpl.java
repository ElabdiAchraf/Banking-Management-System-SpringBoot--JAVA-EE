package com.example.tp14.services;


import com.example.tp14.entities.Groupe;
import com.example.tp14.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService {
    @Autowired
    private GroupeRepository groupeRepository;
    @Override
    public Groupe saveGroupe(Groupe g) {
        return groupeRepository.save(g);
    }
    @Override
    public List<Groupe> listGroupes() {
        return groupeRepository.findAll();
    }
    @Override
    public void DeleteGroupe(Long id) {
        groupeRepository.deleteById(id);
    }
}
