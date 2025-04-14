package com.prjdoces.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjdoces.api.DTO.PedidoResponseDTO;
import com.prjdoces.api.entities.Pedido;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.mapper.PedidoMapper;
import com.prjdoces.api.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Métodos

    @PostMapping()
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.savePedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoMapper.toDTO(pedidoSalvo));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable("id") Long id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<Pedido>> getPedidoByUsuario(@PathVariable("usuario") Usuario usuario) {
        List<Pedido> pedido = pedidoService.getPedidoByUsuario(usuario);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
