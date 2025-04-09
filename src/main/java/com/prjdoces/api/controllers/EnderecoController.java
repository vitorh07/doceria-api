package com.prjdoces.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjdoces.api.services.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    
    private final EnderecoService enderecoService;
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
}
