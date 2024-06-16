package com.br.Kodominio.modelos.entidades;

import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import com.br.Kodominio.modelos.role.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "senha", nullable = false)
    private String senha;

    @NotNull(message = "Este campo é obrigatório")
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_condominio")
    @JsonBackReference("condominio-usuarios")
    private Condominio condominio;

    @Column(name = "apartamento", nullable = true)
    private String apartamento;

    @Column(name = "role", nullable = false)
    private Role role;

    public Usuario(String nome, String email, String senha, String telefone, Condominio condominio, String apartamento, Role role){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.condominio = condominio;
        this.apartamento = apartamento;
        this.role = role;
    }

    //Especificando as autorizações de cada role
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.OWNER) return List.of(new SimpleGrantedAuthority("ROLE_OWNER"), new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_SINDICO"),
                new SimpleGrantedAuthority("ROLE_PORTEIRO"), new SimpleGrantedAuthority("ROLE_MORADOR"));
        else if (this.role == Role.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_SINDICO"),
                new SimpleGrantedAuthority("ROLE_PORTEIRO"), new SimpleGrantedAuthority("ROLE_MORADOR"));
        else if (this.role == Role.SINDICO) return List.of(new SimpleGrantedAuthority("ROLE_SINDICO"), new SimpleGrantedAuthority("ROLE_PORTEIRO"),
                new SimpleGrantedAuthority("ROLE_MORADOR"));
        else if (this.role == Role.PORTEIRO) return List.of(new SimpleGrantedAuthority("ROLE_PORTEIRO"), new SimpleGrantedAuthority("ROLE_MORADOR"));
        else return List.of(new SimpleGrantedAuthority("ROLE_MORADOR"), new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
