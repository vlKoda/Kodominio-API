package com.br.Kodominio.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@EqualsAndHashCode(of = "id")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_administrador")
    private Integer id;

    @Column(name = "condominio", nullable = false)
    private String condominio;
}
