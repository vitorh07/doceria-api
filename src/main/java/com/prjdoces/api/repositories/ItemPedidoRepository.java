package com.prjdoces.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.ItemPedido;
import com.prjdoces.api.entities.Usuario;

import java.util.List;


public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findByUsuario(Usuario usuario);
}

