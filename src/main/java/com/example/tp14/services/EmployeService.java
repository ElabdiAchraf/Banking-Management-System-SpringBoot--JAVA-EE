package com.example.tp14.services;

import com.example.tp14.entities.Employe;

import java.util.List;

public interface EmployeService {
    public Employe saveEmploye(Employe e);
    public List<Employe> listEmployes();
    public void DeleteEmploye(Long id);
}
