package com.example.tp14.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue
    private  long code_cli;
    private String nom_cli;
    @OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
    private Collection<Compte> comptes;
    public Client(){}

    public Client(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public long getCode_cli() {
        return code_cli;
    }

    public void setCode_cli(long code_cli) {
        this.code_cli = code_cli;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
