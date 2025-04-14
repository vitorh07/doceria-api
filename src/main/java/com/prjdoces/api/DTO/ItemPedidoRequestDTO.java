package com.prjdoces.api.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoRequestDTO {
    private Long idProduto;
    private int quantidade;
    private Long idUsuario;
    private UsuarioResumoDTO usuario;
}
