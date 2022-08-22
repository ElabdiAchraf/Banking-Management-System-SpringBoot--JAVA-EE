package com.example.tp14.controllers;


import com.example.tp14.entities.Groupe;
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
public class GroupeController {
    @Autowired
    private GroupeService groupeMetier;
    @RequestMapping(value="/saveGroupe",method= RequestMethod.POST)
    public String saveGroupe(@ModelAttribute("groupe") Groupe g) {
         groupeMetier.saveGroupe(g);
         return "redirect:groupes";
    }
    @RequestMapping(value="/groupes",method=RequestMethod.GET)
    public String listGroupes(Model model) {
       List<Groupe> groupes = groupeMetier.listGroupes();
        Groupe groupe = new Groupe();
        model.addAttribute("groupe", groupe);
       model.addAttribute("groupes",groupes);
       return "Groupe/Groupes";
    }
    @GetMapping(path="/deleteGroupe")
    private String delete(Long id) {
        groupeMetier.DeleteGroupe(id);
        return "redirect:groupes";
    }
}
