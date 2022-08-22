package com.example.tp14.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING,length = 2)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(name="CC",value=CompteCourant.class),
        @JsonSubTypes.Type(name="CE",value=CompteEpargne.class)
})
public abstract class  Operation implements Serializable {
    @Id
    @GeneratedValue
    private long numero;
    private Date dateOperation ;
    private double montant ;
    @ManyToOne()
    @JoinColumn(name = "code_emp")
    private Employe employe;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    @ManyToOne()
    @JoinColumn(name = "code_compte")
    private Compte compte;

    public Operation(Date dateOperation, double montant, Employe employe, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.employe = employe;
        this.compte = compte;
    }

    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }
    public String getDecriminatorValue() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }
    public Operation() {
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
