package com.br.Kodominio.modelos.entidades;


import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Integer id;

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
    private String cep;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("condominio")
    @JsonManagedReference("condominio-ocorrencias")
    private List<Ocorrencia> ocorrencias;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("condominio")
    @JsonManagedReference("condominio-usuarios")
    private List<Usuario> usuarios;


}
