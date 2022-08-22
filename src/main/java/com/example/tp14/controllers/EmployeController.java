package com.example.tp14.controllers;


import com.example.tp14.entities.Employe;
import com.example.tp14.entities.Groupe;
import com.example.tp14.services.EmployeService;
import com.example.tp14.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeController {

    @Autowired
    private EmployeService employeMetier;
    @Autowired
    private GroupeService groupeMetier;

    @RequestMapping(value = "/saveEmploye",method = RequestMethod.POST)
    public String saveEmploye(Employe employe){
        System.out.println("------- ebb-----");
        employeMetier.saveEmploye(employe);
        return "redirect:/employes";
    }
    @GetMapping("/AjouterEmploye")
    public String AjouterEmploye(Model model) {
        Employe employe= new Employe();
        List<Groupe> Listegroupes = groupeMetier.listGroupes();
        model.addAttribute("employe", employe);
        model.addAttribute("Listegroupes",Listegroupes);
        return "Employe/AjouterEmploye";
    }

    @RequestMapping(value = "/employes",method = RequestMethod.GET)
    public String listEmploye(Model model){
        List<Employe> employes = employeMetier.listEmployes();
        Employe employe= new Employe();
        List<Groupe> Listegroupes = groupeMetier.listGroupes();
        model.addAttribute("employe", employe);
        model.addAttribute("Listegroupes",Listegroupes);
        model.addAttribute("listeEmployes",employes);
        return "Employe/Employes";
    }
    @GetMapping(path="/deleteEmploye")
    private String delete(Long id) {
        employeMetier.DeleteEmploye(id);
        return "redirect:employes";
    }

}
