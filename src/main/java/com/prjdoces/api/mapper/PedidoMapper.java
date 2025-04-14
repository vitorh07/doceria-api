package com.prjdoces.api.mapper;

import com.prjdoces.api.DTO.*;
import com.prjdoces.api.entities.*;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoResponseDTO toDTO(Pedido pedido) {
        PedidoResponseDTO dto = new PedidoResponseDTO();

        dto.setIdPedido(pedido.getId_pedido());
        dto.setDataPedido(pedido.getData_pedido());
        dto.setStatus(pedido.getStatus());

        // Usuário
        UsuarioResumoDTO usuarioDTO = new UsuarioResumoDTO();
        usuarioDTO.setIdUsuario(pedido.getUsuario().getId_usuario());
        usuarioDTO.setNome(pedido.getUsuario().getNome());
        usuarioDTO.setEmail(pedido.getUsuario().getEmail());
        dto.setUsuario(usuarioDTO);

        // Endereço
        Endereco endereco = pedido.getEndereco();
        EnderecoResumoDTO enderecoDTO = new EnderecoResumoDTO();
        enderecoDTO.setRua(endereco.getRua());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        dto.setEndereco(enderecoDTO);

        // Itens do pedido
        List<ItemPedidoResponseDTO> itensDTO = pedido.getItens().stream().map(item -> {
            ItemPedidoResponseDTO itemDTO = new ItemPedidoResponseDTO();
            itemDTO.setQuantidade(item.getQuantidade());

            ProdutoResumoDTO produtoDTO = new ProdutoResumoDTO();
            produtoDTO.setIdProduto(item.getProduto().getId_produto());
            produtoDTO.setNome(item.getProduto().getNome());
            itemDTO.setProduto(produtoDTO);

            return itemDTO;
        }).collect(Collectors.toList());

        dto.setItens(itensDTO);

        return dto;
    }

}
