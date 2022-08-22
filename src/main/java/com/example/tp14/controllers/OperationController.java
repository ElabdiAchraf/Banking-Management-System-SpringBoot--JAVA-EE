package com.example.tp14.controllers;

import com.example.tp14.entities.Compte;
import com.example.tp14.services.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OperationController {

    @Autowired private IOperationService iOperationService;
    @RequestMapping("/operations")
    public String index(){
        return "compte";
    }

    @RequestMapping("/consulterCompte1")
    public String consulterCompte(Model model,String code_compte){
        try {
            Compte cp = iOperationService.consulterCompte(code_compte);
            model.addAttribute("compte",cp);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "compte";
    }
    @RequestMapping(value="/saveOperation",method= RequestMethod.POST)
    public String saveOperation(Model model,String typeOperation, String codeCompte,double montant, String codeCompte2, long codeEmp) {
        try {
            if(typeOperation.equals("VERS")) {
                iOperationService.verser(codeCompte,montant,codeEmp);
            } else if(typeOperation.equals("RET")) {
                iOperationService.retirer(codeCompte,montant,codeEmp);
            } else  {
                iOperationService.verement(codeCompte,codeCompte2,montant,codeEmp);
            }
        }catch (Exception e) {
            model.addAttribute("error",e);
            return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
        }
        return "redirect:/consulterCompte?codeCompte="+codeCompte;

    }

}
