package com.br.Kodominio.modelos.entidades;


import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "condominio")
@Data
@EqualsAndHashCode(of = "id")
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "rua", nullable = false, length = 200)
    private String rua;

    @Column(name = "numero", nullable = false, length = 4)
    private Short numero;

    @Column(name = "bairro", nullable = false, length = 200)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 200)
    private String cidade;

    @Column(name = "estado", nullable = false, length = 200)
    private String estado;

    @Column(name = "cep", length = 8)
    private Integer cep;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ocorrencia> ocorrencias;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("condominio")
    private List<Usuario> usuarios;


}
