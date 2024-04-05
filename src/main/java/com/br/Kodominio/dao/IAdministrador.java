package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Administrador;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

@EnableJpaRepositories
public interface IAdministrador extends CrudRepository<Administrador, Integer> {

}
