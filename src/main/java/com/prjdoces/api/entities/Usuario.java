package com.prjdoces.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nome;
    private String username;
    private String email;
    private String senha;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_telefone")
    private Telefone telefone;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_tipo")
    private Tipos id_tipo;
}
