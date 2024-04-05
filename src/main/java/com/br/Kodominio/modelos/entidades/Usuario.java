package com.br.Kodominio.modelos.entidades;

import com.br.Kodominio.modelos.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "usuario")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO")
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 40)
    protected String nome;

    @Column(name = "email", nullable = false, length = 40)
    protected String email;

    @Column(name = "senha", nullable = false, length = 40)
    protected String senha;

    @Column(name = "telefone", nullable = false, length = 11)
    protected String telefone;

    @ManyToMany
    private List<Role> roles;
}
