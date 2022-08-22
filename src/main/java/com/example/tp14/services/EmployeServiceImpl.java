package com.example.tp14.services;


import com.example.tp14.entities.Employe;
import com.example.tp14.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public Employe saveEmploye(Employe e) {
        return employeRepository.save(e);
    }
    @Override
    public List<Employe> listEmployes() {
        return employeRepository.findAll();
    }
    @Override
    public void DeleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }
}
