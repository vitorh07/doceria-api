package com.prjdoces.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjdoces.api.services.TelefoneService;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController {
    
    private final TelefoneService telefoneService;

    public TelefoneController(TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }
}
