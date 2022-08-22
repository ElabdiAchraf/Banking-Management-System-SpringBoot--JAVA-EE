package com.example.tp14.repositories;

import com.example.tp14.entities.Client;
import com.example.tp14.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte,String> {
    @Query("SELECT c FROM Compte c WHERE c.codeCompte = ?1 ")
    Compte findByCodeCompte(String code);

}
