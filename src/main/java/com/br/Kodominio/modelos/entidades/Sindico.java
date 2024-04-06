package com.br.Kodominio.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sindico")
@Data
@DiscriminatorValue("sindico")
// @Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@EqualsAndHashCode(of = "id")
public class Sindico extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sindico")
    private Integer id;

    @Column(name = "condominio", nullable = false)
    private String condominio;

}
