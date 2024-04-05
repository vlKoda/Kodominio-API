package com.br.Kodominio.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sindico")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@EqualsAndHashCode(of = "id")
public class Sindico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sindico")
    private Integer id;

    @Column(name = "condominio", nullable = false)
    private String condominio;

}
