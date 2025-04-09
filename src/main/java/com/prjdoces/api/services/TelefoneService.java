package com.prjdoces.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjdoces.api.entities.Telefone;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.repositories.TelefoneRepository;

@Service
public class TelefoneService {
    
    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    // Métodos
    public void deleteTelefone(Long id) {
        telefoneRepository.deleteById(id);
    }

    public Telefone saveTelefone(Telefone telefone){
        return telefoneRepository.save(telefone);
    }

    public List<Telefone> getAllTelefones(){
        return telefoneRepository.findAll();
    }

    public Telefone getTelefoneById(Long id){
        return telefoneRepository.findById(id).orElse(null);
    }

    public List<Telefone> getTelefoneByUsuario(Usuario usuario){
        return telefoneRepository.findByUsuario(usuario);
    }
}
