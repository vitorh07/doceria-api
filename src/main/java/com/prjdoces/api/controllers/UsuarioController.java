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
        usuario.setId_tipo(usuarioService.getTipoById(idTipo)); // Certifique-se de que o método getTipoById existe no service
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
        // Buscar o usuário pelo identifier (username ou email)
        Usuario usuario = usuarioService.login(loginRequest.getIdentifier(), loginRequest.getSenha());

        if (usuario != null && passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())) {
            // Gerar o token JWT
            String token = JwtUtil.generateToken(usuario.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", token); // Retornar o token
            return ResponseEntity.ok(response);
        }

        // Retornar 401 se as credenciais forem inválidas
        return ResponseEntity.status(401).body(null);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserDetails(@RequestHeader("Authorization") String authorizationHeader) {
        // Verificar se o cabeçalho Authorization está presente
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(400).body("Token JWT não fornecido ou inválido.");
        }

        // Extrair o token do cabeçalho
        String token = authorizationHeader.substring(7); // Remove "Bearer "

        // Validar o token
        if (!JwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Token inválido ou expirado.");
        }

        // Extrair o username do token
        String username = JwtUtil.extractUsername(token);

        // Buscar o usuário no banco de dados
        Usuario usuario = usuarioService.getUsuarioByUsername(username);
        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }

        // Retornar as informações do usuário
        return ResponseEntity.ok(usuario);
    }
}
