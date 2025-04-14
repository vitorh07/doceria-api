package com.prjdoces.api.controllers;

import com.prjdoces.api.DTO.ItemPedidoRequestDTO;
import com.prjdoces.api.DTO.ItemPedidoResponseDTO;
import com.prjdoces.api.entities.ItemPedido;
import com.prjdoces.api.entities.Usuario;
import com.prjdoces.api.services.ItemPedidoService;
import com.prjdoces.api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private ProdutoService produtoService; // Serviço para buscar o Produto

    @PostMapping
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedidoRequestDTO dto) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setProduto(produtoService.getProdutoById(dto.getIdProduto()));
        itemPedido.setQuantidade(dto.getQuantidade());
        itemPedido.setPreco_unitario(itemPedido.getProduto().getPreco());

        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getIdUsuario());
        itemPedido.setUsuario(usuario);

        ItemPedido novoItemPedido = itemPedidoService.salvarItemPedido(itemPedido);
        return ResponseEntity.ok(novoItemPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDTO> getItemPedido(@PathVariable Long id) {
        ItemPedidoResponseDTO itemPedidoResponse = itemPedidoService.getItemPedido(id);

        if (itemPedidoResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(itemPedidoResponse);
    }

}
