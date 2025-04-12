package com.prjdoces.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjdoces.api.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    List<Produto> findByNome(String nome);
}
