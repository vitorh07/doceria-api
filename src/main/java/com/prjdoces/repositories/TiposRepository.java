package com.prjdoces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.entities.Tipos;

public interface TiposRepository extends JpaRepository<Tipos, Long>{
    
}
