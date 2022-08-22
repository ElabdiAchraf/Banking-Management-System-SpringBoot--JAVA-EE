package com.example.tp14.controllers;

import com.example.tp14.entities.*;
import com.example.tp14.repositories.ClientRepository;
import com.example.tp14.repositories.CompteRepository;
import com.example.tp14.repositories.EmployeRepository;
import com.example.tp14.services.ICompteService;
import com.example.tp14.services.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CompteController {
    @Autowired
    private ICompteService iCompteService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private IOperationService iOperationService;
    @RequestMapping(value = "/consulterCompte")
    public String consulterCompte(
            @RequestParam(name="codeCompte") String code,
            String error,
            Model model,
            @RequestParam(name="page",defaultValue="0")int page,
            @RequestParam(name="size",defaultValue="5")int size)
    {
        try {
            List<Employe> employes = employeRepository.findAll();
            model.addAttribute("employes",employes);
            List<Compte> comptes = compteRepository.findAll();
            model.addAttribute("comptes",comptes);
            Compte cpt = iCompteService.consulterCompte(code);
           // model.addAttribute("compte",cpt);
            String val =cpt.getDecriminatorValue();
            switch (val){
                case"CE":{
                    System.out.println("-----------------CE---------------------");
                    CompteEpargne cp = (CompteEpargne)cpt;
                    model.addAttribute("compte",iCompteService.consulterCompte(code));
                    model.addAttribute("taux",cp.getTaux());
                }
                case"CC" :{
                    System.out.println("------------------CC-------------------");
                    CompteCourant cp = (CompteCourant)cpt;
                    model.addAttribute("compte",iCompteService.consulterCompte(code));
                    model.addAttribute("decouvert",cp.getDecouvert());
                }
            }
            Page<Operation> pageOperations = iOperationService.listOperation(code ,page, size);
            model.addAttribute("listOperations",pageOperations.getContent());
            int[] pages=new int[pageOperations.getTotalPages()];
            model.addAttribute("pages", pages);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "compte/compte";
    }

    // add form Compte
    @RequestMapping("/compte/add/{id}")
    public String addCompte(@PathVariable("id") long id ,Model model){
        model.addAttribute("client_id",id);
        return "compte/addCompte";
    }

    // Save Compte
    @RequestMapping("/saveCompte")
    @Transactional
    public String saveCompte(
            String codeCompte,
            double solde,
            String typeOperation,
            double taux ,
            double decouvert,
            Model model ,
            long client_id){
        try {
            Client c1 = clientRepository.findByCodeClient(client_id);
            Employe em=employeRepository.findByCode(1l);
            if (typeOperation.equals("CC")){
                Compte cp =compteRepository.save(
                        new CompteCourant(codeCompte,new Date(),solde,c1,em,decouvert)
                );
                Compte compte = iCompteService.saveCompte(cp);
            }
            else if(typeOperation.equals("CE")){
                Compte cp =compteRepository.save(
                        new CompteEpargne(codeCompte,new Date(),solde,c1,em,taux)
                );
                Compte compte = iCompteService.saveCompte(cp);
            }
        }catch (Exception e){
            model.addAttribute("exception",e);
        }

        return "redirect:/showClient/"+client_id;
    }
    // delete client
    @PostMapping("/deleteCompte")
    public String deleteClient( String code, Model model, String codeclient) {
    Compte compte = iCompteService.findCompteByCode(code);
    iCompteService.deleteCompte(compte);
        return "redirect:/showClient/"+codeclient;
    }
}
