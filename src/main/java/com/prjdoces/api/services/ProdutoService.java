package com.prjdoces.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjdoces.api.repositories.ProdutoRepository;
import com.prjdoces.api.entities.Produto;

@Service
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    // Métodos
    
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public List<Produto> getProdutoByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }
}
