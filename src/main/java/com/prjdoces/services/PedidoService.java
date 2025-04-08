package com.prjdoces.services;

import org.springframework.stereotype.Service;

import com.prjdoces.repositories.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
