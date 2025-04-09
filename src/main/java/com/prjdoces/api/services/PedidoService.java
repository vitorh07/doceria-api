package com.prjdoces.api.services;

import org.springframework.stereotype.Service;

import com.prjdoces.api.repositories.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
