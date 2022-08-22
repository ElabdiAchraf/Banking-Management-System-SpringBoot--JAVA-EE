package com.example.tp14.services;

import com.example.tp14.entities.Client;
import com.example.tp14.entities.Compte;
import com.example.tp14.entities.CompteCourant;
import com.example.tp14.entities.CompteEpargne;
import com.example.tp14.repositories.ClientRepository;
import com.example.tp14.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteServiceImpl implements ICompteService {
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public Compte consulterCompte(String code_cpt) {
        Compte cp = compteRepository.findById(code_cpt).get();
        if (cp==null){
            throw new RuntimeException("Compte introuvable!!!");
        }
        return cp;
    }


    @Override
    public Compte saveCompte(Compte c) {
        return compteRepository.save(c);
    }

    @Override
    public void deleteCompte(Compte c) {
        compteRepository.delete(c);
    }

    @Override
    public List<Compte> ListCompte() {
        return compteRepository.findAll();
    }

    @Override
    public Compte findCompteByCode(String code) {
        return compteRepository.findByCodeCompte(code);
    }


}
