package com.example.tp14.repositories;

import com.example.tp14.entities.Compte;
import com.example.tp14.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    @Query("SELECT e FROM Employe e WHERE e.codeEmp = ?1")
    Employe findByCode(Long id);
}
