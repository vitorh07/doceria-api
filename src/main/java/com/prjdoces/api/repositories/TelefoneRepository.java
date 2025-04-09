package com.prjdoces.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    
}
