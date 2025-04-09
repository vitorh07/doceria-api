package com.prjdoces.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
