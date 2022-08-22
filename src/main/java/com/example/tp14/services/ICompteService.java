package com.example.tp14.services;

import com.example.tp14.entities.Client;
import com.example.tp14.entities.Compte;
import com.example.tp14.entities.CompteCourant;
import com.example.tp14.entities.CompteEpargne;

import java.util.List;
import java.util.Optional;

public interface ICompteService {
    public Compte consulterCompte(String code_cpt);
    public Compte saveCompte (Compte c);
    public void deleteCompte (Compte c);
   // public List<Compte> listCompte ();
    public List<Compte> ListCompte();
    public Compte  findCompteByCode(String code);
}
