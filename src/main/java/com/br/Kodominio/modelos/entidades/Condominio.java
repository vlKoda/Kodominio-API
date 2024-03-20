package com.br.Kodominio.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Short numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cep")
    private Integer cep;
}
