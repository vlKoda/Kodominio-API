package com.br.Kodominio.modelos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@EqualsAndHashCode(of = "id")
public class Owner extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_owner")
    private Integer id;


}
