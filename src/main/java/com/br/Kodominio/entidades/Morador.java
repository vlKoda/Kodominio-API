package com.br.Kodominio.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "MORADOR")
public class Morador extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;


}
