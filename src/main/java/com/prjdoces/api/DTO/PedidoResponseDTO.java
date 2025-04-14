package com.prjdoces.api.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoResponseDTO {
    private Long idPedido;
    private LocalDateTime dataPedido;
    private String status;
    private UsuarioResumoDTO usuario;
    private EnderecoResumoDTO endereco;
    private List<ItemPedidoResponseDTO> itens;
}

