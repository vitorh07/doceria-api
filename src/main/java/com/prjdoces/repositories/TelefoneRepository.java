package com.prjdoces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    
}
