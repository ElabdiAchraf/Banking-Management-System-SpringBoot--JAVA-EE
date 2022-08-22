package com.example.tp14.controllers;


import com.example.tp14.entities.*;
import com.example.tp14.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {
    private List<Employe> Employes;
    private List<Client> Clients;
    private List<Groupe> Groupes;
    private List<Compte> Comptes;
    private List<Operation> Operations;

    @Autowired
    private EmployeService employeMetier;
    @Autowired
    private IClientService clientMetier;
    @Autowired
    private GroupeService groupeMetier;
    @Autowired
    private ICompteService compteMetier;
    @Autowired
    private IOperationService operationMetier;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("chartData", getChartData());
        model.addAttribute("Employes",employeMetier.listEmployes().size());
        model.addAttribute("Clients",clientMetier.listClient().size());
        model.addAttribute("Operations",operationMetier.getOperations().size());
        model.addAttribute("Comptes",compteMetier.ListCompte().size());
        model.addAttribute("Groupes",groupeMetier.listGroupes().size());
        return "index";
    }

    private List<List<Object>> getChartData() {
        Employes = employeMetier.listEmployes();
        Operations = operationMetier.getOperations();
        Comptes = compteMetier.ListCompte();
        Groupes = groupeMetier.listGroupes();
        Clients = clientMetier.listClient();
        return List.of(
               List.of("Employes",Employes.size()),
                List.of("Operations",Operations.size() ),
                List.of("Comptes",Comptes.size() ),
                List.of("Groupes",Groupes.size() ),
                List.of("Clients",Clients.size() )
        );
    }
}
