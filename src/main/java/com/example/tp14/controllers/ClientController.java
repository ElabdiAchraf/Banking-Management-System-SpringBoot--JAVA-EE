package com.example.tp14.controllers;

import com.example.tp14.entities.Client;
import com.example.tp14.entities.Compte;
import com.example.tp14.repositories.ClientRepository;
import com.example.tp14.services.IClientService;
import com.example.tp14.services.ICompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private IClientService iClientService;
    @Autowired
    private ICompteService iCompteService;
    @Autowired
    private ClientRepository clientRepository;

    //list Clients
    @RequestMapping("/clients")
    public String index(Model model){
        try {
            List<Client> clients = iClientService.listClient();
            model.addAttribute("clients",clients);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "client/client";
    }
    //show Client
    @GetMapping("/showClient/{id}")
    public String showClient(@PathVariable("id") long id, Model model) {
        try {
            Client client = iClientService.findClientByCode(id);
            model.addAttribute("client", client);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "client/showClient";
    }

    // add form client
    @RequestMapping("/addClient")
    public String addClient(){
        return "client/addClient";
    }
    // Save Client
    @RequestMapping("/saveClient")
    public String saveClient(String name, Model model){
        try {
          Client c=new Client(name);
          Client client = iClientService.saveClient(c);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "redirect:/clients";
    }

    //show Update Form
    @GetMapping("/updateClient/{id}")
    public Client showUpdateForm(@PathVariable("id") long id, Model model) {
        try {
            Client client = iClientService.findClientByCode(id);
            model.addAttribute("client", client);
            return client;
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return null;
    }

    //update client
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, String name, Model model) {
        Client client = iClientService.findClientByCode(id);
        client.setCode_cli(id);
        client.setNom_cli(name);
        iClientService.saveClient(client);
        return "redirect:/clients";
    }

    // delete client
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
   Client client = iClientService.findClientByCode(id);
    clientRepository.delete(client);
        return "redirect:/clients";
    }
}
