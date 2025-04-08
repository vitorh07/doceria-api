package com.prjdoces.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjdoces.entities.Usuario;
import com.prjdoces.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Métodos
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario findUsuarioById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> findAllUsuarios(){
        return usuarioRepository.findAll();
    }
    
    public Usuario findUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario findUsuarioByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }
}
