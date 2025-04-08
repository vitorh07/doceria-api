package com.prjdoces.services;

import org.springframework.stereotype.Service;

import com.prjdoces.repositories.TiposRepository;

@Service
public class TiposService {
    
    private final TiposRepository tiposRepository;

    public TiposService(TiposRepository tiposRepository) {
        this.tiposRepository = tiposRepository;
    }
}
