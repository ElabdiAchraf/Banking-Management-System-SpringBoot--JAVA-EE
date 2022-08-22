package com.example.tp14.services;

import com.example.tp14.entities.Compte;
import com.example.tp14.entities.Operation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOperationService {
    public Compte consulterCompte(String code_cpt);
    public void verser(String code_cpt,double montant ,long codeEmp);
    public void retirer(String code_cpt,double montant,long codeEmp );
    public void verement(String code_cpt1,String code_cpt2,double montant,long codeEmp);;
    public Page<Operation> listOperation(String code_cpt, int page ,int size);
    public List<Operation> getOperations();
}
