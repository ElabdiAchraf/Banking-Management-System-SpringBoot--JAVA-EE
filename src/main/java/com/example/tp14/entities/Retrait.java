package com.example.tp14.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("OR")
public class Retrait extends Operation{


    public Retrait() {
        super();
    }

    public Retrait(Date dateOperation, double montant, Employe employe, Compte compte) {
        super(dateOperation, montant, employe, compte);
    }

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
