package com.br.Kodominio.modelos.entidades;

import com.br.Kodominio.modelos.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO")
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    protected String nome;

    @Column(name = "email")
    protected String email;

    @Column(name = "senha")
    protected String senha;

    @Column(name = "telefone")
   protected String telefone;

    @ManyToMany
    private List<Role> roles;
}
