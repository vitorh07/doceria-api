package com.prjdoces.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Endereco;
import com.prjdoces.api.entities.Usuario;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByUsuario(Usuario usuario);
}
