package com.prjdoces.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Telefone;
import com.prjdoces.api.entities.Usuario;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    List<Telefone> findByUsuario(Usuario usuario);
}
