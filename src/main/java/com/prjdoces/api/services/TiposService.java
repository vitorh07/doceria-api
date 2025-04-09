package com.prjdoces.api.services;

import org.springframework.stereotype.Service;

import com.prjdoces.api.repositories.TiposRepository;

@Service
public class TiposService {
    
    private final TiposRepository tiposRepository;

    public TiposService(TiposRepository tiposRepository) {
        this.tiposRepository = tiposRepository;
    }
}
