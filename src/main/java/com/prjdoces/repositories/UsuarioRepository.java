package com.prjdoces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
    public Usuario findByCpf(String cpf);
}
