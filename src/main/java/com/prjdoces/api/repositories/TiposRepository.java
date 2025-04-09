package com.prjdoces.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Tipos;

public interface TiposRepository extends JpaRepository<Tipos, Long>{
    
}
