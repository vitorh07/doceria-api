package com.prjdoces.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjdoces.api.entities.Telefone;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.services.TelefoneService;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController {

    private final TelefoneService telefoneService;

    public TelefoneController(TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }

    // Métodos

    @PostMapping
    public ResponseEntity<?> createTelefone(@RequestBody Telefone telefone) {
        Telefone savedTelefone = telefoneService.saveTelefone(telefone);
        return ResponseEntity.ok(savedTelefone);
    }

    @GetMapping
    public ResponseEntity<?> getAllTelefones() {
        List<Telefone> telefones = telefoneService.getAllTelefones();
        return ResponseEntity.ok(telefones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTelefoneById(@PathVariable Long id) {
        Telefone telefone = telefoneService.getTelefoneById(id);
        if (telefone != null) {
            return ResponseEntity.ok(telefone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usuario/{usuario}")
	public ResponseEntity<List<Telefone>> getTelefoneByUsuario(@PathVariable("usuario") Usuario usuario) {
		List<Telefone> telefone = telefoneService.getTelefoneByUsuario(usuario);
		if (telefone != null) {
			return ResponseEntity.ok(telefone);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefone(@PathVariable Long id) {
		if (telefoneService.getTelefoneById(id) != null) {
			telefoneService.deleteTelefone(id);
			return ResponseEntity.noContent().build(); 
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}