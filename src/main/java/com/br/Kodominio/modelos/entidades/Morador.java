package com.br.Kodominio.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@EqualsAndHashCode(of = "id")
public class Morador extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "condominio")
    private String condominio;




}
