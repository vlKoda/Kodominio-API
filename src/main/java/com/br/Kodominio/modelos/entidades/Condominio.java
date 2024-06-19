package com.br.Kodominio.modelos.entidades;


import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "condominio")
@Data
@EqualsAndHashCode(of = "id")
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "rua", nullable = false, length = 200)
    private String rua;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "numero", nullable = false, length = 4)
    private Short numero;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "bairro", nullable = false, length = 200)
    private String bairro;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "cidade", nullable = false, length = 200)
    private String cidade;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "estado", nullable = false, length = 200)
    private String estado;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "cep", nullable = false, length = 8)
    private String cep;


    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("condominio")
    @JsonManagedReference("condominio-ocorrencias")
    @BatchSize(size = 20)
    private Set<Ocorrencia> ocorrencias;


    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("condominio")
    @JsonManagedReference("condominio-usuarios")
    @BatchSize(size = 20)
    private Set<Usuario> usuarios;


}
