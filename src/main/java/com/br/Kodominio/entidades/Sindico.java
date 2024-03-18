package com.br.Kodominio.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SINDICO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Sindico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

}
