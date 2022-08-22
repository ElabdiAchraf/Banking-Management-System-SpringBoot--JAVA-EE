package com.example.tp14;

import com.example.tp14.entities.Client;
import com.example.tp14.entities.Compte;
import com.example.tp14.entities.CompteCourant;
import com.example.tp14.entities.Employe;
import com.example.tp14.repositories.ClientRepository;
import com.example.tp14.repositories.CompteRepository;
import com.example.tp14.repositories.EmployeRepository;
import com.example.tp14.services.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class Tp14Application implements CommandLineRunner {
    @Autowired private ClientRepository clientRepository;
    @Autowired private CompteRepository compteRepository;
    @Autowired private IOperationService iOperationService;
    @Autowired private EmployeRepository employeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp14Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employe em1=employeRepository.save(new Employe("achraf",null));
        Employe em2=employeRepository.findByCode(1l);
//        Employe em3=employeRepository.save(new Employe("achraf2",em2));
//        Employe em4=employeRepository.save(new Employe("achraf3",em3));
//        Employe em5=employeRepository.save(new Employe("achraf4",em3));
//
//
//          Client c1 =clientRepository.save(new Client("achraf"));
//    //     Client c2 =clientRepository.save(new Client("elabdi"));
//         Compte cp1 =compteRepository.save(new CompteCourant("achraf2001",new Date(),90000,c1,em3,6000));
//    //     Compte cp2 =compteRepository.save(new CompteEpargne("achraf2002",new Date(),90000,c2,10));
//    //     iClientService.verser("achraf2001",100000);
//        Compte cp2 =compteRepository.save(new CompteCourant("achraf2001",new Date(),90000,c1,em3,6000));
//        compteRepository.delete(cp2);
    }
}
