package com.prjdoces.api.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    private String status;
    private LocalDateTime data_pedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    // Remova o 'mappedBy' e use 'JoinColumn' diretamente na tabela 'ItemPedido'
    @OneToMany
    @JoinColumn(name = "id_pedido")  // Agora ItemPedido vai ter o campo 'id_pedido' como chave estrangeira
    private List<ItemPedido> itens = new ArrayList<>(); // Inicializando a lista para evitar NullPointerException

    @JsonCreator
    public Pedido(
            @JsonProperty("id_usuario") Long id_usuario,
            @JsonProperty("id_endereco") Long id_endereco) {

        this.usuario = new Usuario();
        this.usuario.setId_usuario(id_usuario);

        this.endereco = new Endereco();
        this.endereco.setId_endereco(id_endereco);

        // Inicializando a lista de itens
        this.itens = new ArrayList<>();

        // Preenchendo data e status
        this.data_pedido = LocalDateTime.now(); // data atual
        this.status = "Pendente"; // Definindo o status como "Pendente" por padrão
    }
}
