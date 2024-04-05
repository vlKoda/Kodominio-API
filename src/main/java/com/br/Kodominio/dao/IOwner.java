package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Owner;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface IOwner extends CrudRepository<Owner, Integer> {
}
