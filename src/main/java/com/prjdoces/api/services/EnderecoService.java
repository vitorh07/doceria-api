package com.prjdoces.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjdoces.api.entities.Endereco;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.repositories.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private final EnderecoRepository enderecoRepository;
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    // Métodos
    
    public Endereco saveEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco getEnderecoById(Long id){
        return enderecoRepository.findById(id).orElse(null);
    }

    public List<Endereco> getAllEnderecos(){
        return enderecoRepository.findAll();
    }

    public List<Endereco> getEnderecoByUsuario(Usuario usuario){
        return enderecoRepository.findByUsuario(usuario);
    }

    public void deleteEndereco(Long id){
        enderecoRepository.deleteById(id);
    }
}
