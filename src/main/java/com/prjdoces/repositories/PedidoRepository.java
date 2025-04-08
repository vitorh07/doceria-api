package com.prjdoces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
