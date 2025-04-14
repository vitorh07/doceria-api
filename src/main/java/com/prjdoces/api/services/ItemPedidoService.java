package com.prjdoces.api.services;

import com.prjdoces.api.DTO.ItemPedidoResponseDTO;
import com.prjdoces.api.DTO.ProdutoResumoDTO;
import com.prjdoces.api.DTO.UsuarioResumoDTO;
import com.prjdoces.api.entities.ItemPedido;
import com.prjdoces.api.repositories.ItemPedidoRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido salvarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedidoResponseDTO getItemPedido(Long id) {
        Optional<ItemPedido> itemPedidoOpt = itemPedidoRepository.findById(id);
    
        if (itemPedidoOpt.isEmpty()) {
            return null;
        }
    
        ItemPedido itemPedido = itemPedidoOpt.get();
    
        // Criando o DTO de resposta
        ItemPedidoResponseDTO responseDTO = new ItemPedidoResponseDTO();
    
        // Preenchendo o ProdutoResumoDTO
        ProdutoResumoDTO produtoResumoDTO = new ProdutoResumoDTO();
        produtoResumoDTO.setIdProduto(itemPedido.getProduto().getId_produto());
        produtoResumoDTO.setNome(itemPedido.getProduto().getNome());
    
        responseDTO.setProduto(produtoResumoDTO);
        responseDTO.setQuantidade(itemPedido.getQuantidade());
        responseDTO.setPrecoUnitario(itemPedido.getPreco_unitario());
    
        // Preenchendo o UsuarioResumoDTO
        UsuarioResumoDTO usuarioResumoDTO = new UsuarioResumoDTO();
        usuarioResumoDTO.setIdUsuario(itemPedido.getUsuario().getId_usuario());
        usuarioResumoDTO.setNome(itemPedido.getUsuario().getNome());
        usuarioResumoDTO.setEmail(itemPedido.getUsuario().getEmail());
    
        responseDTO.setUsuario(usuarioResumoDTO);  // Agora está correto
    
        return responseDTO;
    }    
}
