package com.example.tp14.services;

import com.example.tp14.entities.*;
import com.example.tp14.repositories.CompteRepository;
import com.example.tp14.repositories.EmployeRepository;
import com.example.tp14.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OperationServiceImp implements IOperationService {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Override
    public Compte consulterCompte(String code_cpt) {
        Compte cp = compteRepository.findByCodeCompte(code_cpt);
        if (cp==null){
            throw new RuntimeException("Compte introuvable!!!");
        }
        return cp;
    }
    @Override
    public void verser(String code_cpt, double montant,long codeEmp) {
        Compte cp = consulterCompte(code_cpt);
        Employe e= employeRepository.findById(codeEmp).orElse(null);
        Versement v= new Versement(new Date(),montant,e,cp);
        cp.setSolde(cp.getSolde()+montant);
        operationRepository.save(v);
        compteRepository.save(cp);
    }

    @Override
    public void retirer(String code_cpt, double montant,long codeEmp) {
        Compte cp = consulterCompte(code_cpt);
        Employe e= employeRepository.findById(codeEmp).orElse(null);
        double fcaisse=0;
        if(cp instanceof CompteCourant)
                fcaisse=((CompteCourant) cp).getDecouvert();
        if(cp.getSolde()+fcaisse<montant)
            throw new RuntimeException("solde insuffisant");
        Retrait r= new Retrait(new Date(),montant,e,cp);
        cp.setSolde(cp.getSolde()-montant);
        operationRepository.save(r);
        compteRepository.save(cp);
    }

    @Override
    public void verement(String code_cpt1, String code_cpt2, double montant,long codeEmp) {
        if(code_cpt1 == code_cpt2) throw new RuntimeException("Impossible : On ne peut pas effectuer un virement dans le meme compte");
        retirer(code_cpt1,montant,codeEmp);
        verser(code_cpt2,montant,codeEmp);
    }

    @Override
    public Page<Operation> listOperation(String code_cpt, int page, int size) {
        return operationRepository.listOprations(code_cpt, PageRequest.of(page,size));
    }

    @Override
    public List<Operation> getOperations() {
        return operationRepository.findAll();
    }
}
