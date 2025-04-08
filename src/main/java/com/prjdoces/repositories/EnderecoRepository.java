package com.prjdoces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
