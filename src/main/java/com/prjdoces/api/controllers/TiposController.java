package com.prjdoces.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjdoces.api.entities.Tipos;
import com.prjdoces.api.services.TiposService;

@RestController
@RequestMapping("/api/tipos")
public class TiposController {
    private final TiposService tiposService;

    public TiposController(TiposService tiposService) {
        this.tiposService = tiposService;
    }

    // Métodos

    @GetMapping
    public List<Tipos> getAllTipos() {
        return tiposService.getAllTipos();
    }
}
