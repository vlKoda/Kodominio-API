package com.br.Kodominio.modelos.ocorrencia;


import com.br.Kodominio.modelos.entidades.Condominio;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "ocorrencia")
@Data
@EqualsAndHashCode(of = "id")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ocorrencia")
    private Integer id;

    @Column(name = "autor")
    private String autor;

    @Column(name = "email")
    private String email;

    @Column(name = "ocorrencia")
    private String bocorrencia;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_condominio", nullable = false)
    private Condominio condominio;

    @Column(name = "data")
    @CreationTimestamp
    private Timestamp datahora;



}
