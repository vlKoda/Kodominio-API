package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Morador;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface IMorador extends CrudRepository<Morador, Integer> {
}
