package com.prjdoces.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjdoces.api.entities.Tipos;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.repositories.TiposRepository;
import com.prjdoces.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;
    private final TiposRepository tiposRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, TiposRepository tiposRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tiposRepository = tiposRepository;
    }

    // Métodos
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    
    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario getUsuarioByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }

    public Usuario getUsuarioByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public Usuario login(String identifier, String senha){
        Usuario usuario = usuarioRepository.findByUsername(identifier);
        if(usuario == null){
            usuario = usuarioRepository.findByEmail(identifier);
        }
        return usuario;
    }

    // Novo método para buscar o tipo de usuário pelo ID
    public Tipos getTipoById(Long id) {
        return tiposRepository.findById(id).orElse(null);
    }
}