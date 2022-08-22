package com.example.tp14.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;


@Entity
@DiscriminatorValue("OV")
public class Versement extends Operation{

    public Versement(Date dateOperation, double montant, Employe employe, Compte compte) {
        super(dateOperation, montant, employe, compte);
    }

    public Versement() {
        super();
    }

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
