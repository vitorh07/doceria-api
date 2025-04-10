package com.prjdoces.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjdoces.api.DTO.LoginRequest;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.security.JwtUtil;
import com.prjdoces.api.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    // Criar
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        Usuario usuario = new Usuario();

        // Preenchendo os atributos do usuário
        usuario.setUsername(request.get("username"));
        usuario.setSenha(passwordEncoder.encode(request.get("senha")));
        usuario.setEmail(request.get("email"));
        usuario.setNome(request.get("nome"));
        usuario.setCpf(request.get("cpf"));

        // Relacionamento com o tipo de usuário
        if (request.get("id_tipo") != null) {
            Long idTipo = Long.parseLong(request.get("id_tipo"));
            usuario.setId_tipo(usuarioService.getTipoById(idTipo));
        }

        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(savedUsuario);
    }

    // Deletar
    @DeleteMapping("/id/{id}")
    public void deleteUser(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

    // Buscar por ID
    @GetMapping("/id/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    // Buscar por Username
    @GetMapping("/username/{username}")
    public Usuario getUsuarioByUsername(@PathVariable String username) {
        return usuarioService.getUsuarioByUsername(username);
    }

    // Buscar por Email
    @GetMapping("/email/{email}")
    public Usuario getUsuarioByEmail(@PathVariable String email) {
        return usuarioService.getUsuarioByEmail(email);
    }

    // Buscar todos
    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioService.getAllUsuarios();
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioService.login(loginRequest.getIdentifier(), loginRequest.getSenha());

        if (usuario != null && passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())) {
            String token = JwtUtil.generateToken(usuario.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body(null);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserDetails(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(400).body("Token JWT não fornecido ou inválido.");
        }
        String token = authorizationHeader.substring(7);
        if (!JwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Token inválido ou expirado.");
        }
        String username = JwtUtil.extractUsername(token);
        Usuario usuario = usuarioService.getUsuarioByUsername(username);
        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }
        return ResponseEntity.ok(usuario);
    }
}
