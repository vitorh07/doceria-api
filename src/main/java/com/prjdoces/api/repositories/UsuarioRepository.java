package com.prjdoces.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
    public Usuario findByCpf(String cpf);
    public Usuario findByUsername(String username);
}
