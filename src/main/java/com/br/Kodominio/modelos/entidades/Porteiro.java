package com.br.Kodominio.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "porteiro")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@EqualsAndHashCode(of = "id")

public class Porteiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_porteiro")
    private Integer id;

    @Column(name = "condominio", nullable = false)
    private String condominio;
}
