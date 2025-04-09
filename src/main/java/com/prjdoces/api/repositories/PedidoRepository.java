package com.prjdoces.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Pedido;
import com.prjdoces.api.entities.Usuario;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuario(Usuario usuario);
}
