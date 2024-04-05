package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Sindico;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface ISindico extends CrudRepository<Sindico, Integer> {
}
