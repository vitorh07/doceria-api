package com.prjdoces.api.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoResponseDTO {
    private ProdutoResumoDTO produto;
    private int quantidade;
    private double precoUnitario;
    private UsuarioResumoDTO usuario;
}
