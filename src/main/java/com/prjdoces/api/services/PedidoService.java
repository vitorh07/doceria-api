package com.prjdoces.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjdoces.api.entities.Pedido;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.repositories.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Métodos
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> getPedidoByUsuario(Usuario usuario) {
        return pedidoRepository.findByUsuario(usuario);
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
