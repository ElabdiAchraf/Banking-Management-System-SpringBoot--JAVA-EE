package com.example.tp14.services;


import com.example.tp14.entities.Groupe;

import java.util.List;

public interface GroupeService {
    public Groupe saveGroupe(Groupe g);
    public List<Groupe> listGroupes();
    public void DeleteGroupe(Long id);
}
