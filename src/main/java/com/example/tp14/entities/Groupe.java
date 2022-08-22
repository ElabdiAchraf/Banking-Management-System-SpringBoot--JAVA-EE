package com.example.tp14.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Groupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeGrp;
    private String nomGrp;
    @ManyToMany()
    private Collection<Employe> employes;

    public Groupe() {
    }

    public long getCodeGrp() {
        return codeGrp;
    }

    public void setCodeGrp(long codeGrp) {
        this.codeGrp = codeGrp;
    }

    public String getNomGrp() {
        return nomGrp;
    }

    public void setNomGrp(String nomGrp) {
        this.nomGrp = nomGrp;
    }
}
