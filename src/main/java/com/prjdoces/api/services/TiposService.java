package com.prjdoces.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjdoces.api.entities.Tipos;
import com.prjdoces.api.repositories.TiposRepository;

@Service
public class TiposService {
    
    private final TiposRepository tiposRepository;

    public TiposService(TiposRepository tiposRepository) {
        this.tiposRepository = tiposRepository;
    }

    // Métodos
    public void deleteTipo(Long id) {
        tiposRepository.deleteById(id);
    }

    public Tipos saveTipo(Tipos tipo) {
        return tiposRepository.save(tipo);
    }

    public List<Tipos> getAllTipos() {
        return tiposRepository.findAll();
    }
}
