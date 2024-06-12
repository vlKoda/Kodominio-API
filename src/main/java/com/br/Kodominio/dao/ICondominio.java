package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Condominio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ICondominio extends CrudRepository<Condominio, Integer> {

    @Query("select distinct c from Condominio c join fetch c.usuarios")
    List<Condominio> findAll();
}
