package com.prjdoces.services;

import org.springframework.stereotype.Service;

import com.prjdoces.repositories.TelefoneRepository;

@Service
public class TelefoneService {
    
    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }
}
