package com.example.tp14.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeEmp;
    private String nomEmp;
    @ManyToOne
    @JoinColumn(name = "code_emp_sup")
    private Employe empSup;
    @ManyToMany()
    @JoinTable(name = "EMP_GR")
    private Collection<Groupe> groups;
    @OneToMany
    private Collection<Operation> operations;

    public Employe(String nomEmp, Employe empSup) {
        this.nomEmp = nomEmp;
        this.empSup = empSup;
//        this.groups = groups;
    }

    public Employe() {
    }



    public long getCodeEmp() {
        return codeEmp;
    }

    public void setCodeEmp(long codeEmp) {
        this.codeEmp = codeEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public Employe getEmpSup() {
        return empSup;
    }

    public void setEmpSup(Employe empSup) {
        this.empSup = empSup;
    }

    public Collection<Groupe> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Groupe> groups) {
        this.groups = groups;
    }
}
