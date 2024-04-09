package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Owner;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

@EnableJpaRepositories
public interface IOwner extends CrudRepository<Owner, Long> {
    UserDetails findByEmail(String email);
}
