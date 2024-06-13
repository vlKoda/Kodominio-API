package com.br.Kodominio.modelos.ocorrencia;


import com.br.Kodominio.modelos.entidades.Condominio;
import com.br.Kodominio.modelos.entidades.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "ocorrencia")
@Data
@EqualsAndHashCode(of = "id")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "autor")
    private String autor;

    @Column(name = "apartamento")
    private String apartamento;

    @Column(name = "email")
    private String email;

    @Column(name = "ocorrencia")
    private String bocorrencia;

    @Column(name = "status")
    private Integer status;

    @Column(name = "prioridade")
    private String prioridade;

    @Column(name = "aprovacao")
    private String aprovacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties("ocorrencias")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_condominio", nullable = false)
    @JsonIgnoreProperties("ocorrencias")
    private Condominio condominio;

    @Column(name = "data")
    @CreationTimestamp
    private Date data;

    @Column(name = "datahora")
    @CreationTimestamp
    private Timestamp datahora;

    @Column(name = "datahora_editada")
    @UpdateTimestamp
    private Timestamp datahora_editada;



}
