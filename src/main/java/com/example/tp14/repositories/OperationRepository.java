package com.example.tp14.repositories;

import com.example.tp14.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
    public Page<Operation> listOprations(@Param("x") String code_compte , Pageable pageable);
}
