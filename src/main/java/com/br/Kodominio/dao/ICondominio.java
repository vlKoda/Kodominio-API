package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Condominio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ICondominio extends CrudRepository<Condominio, Integer> {

    Optional<Condominio> findById(Condominio id);

    @Query("select distinct c from Condominio c join fetch c.usuarios join fetch c.ocorrencias")
    List<Condominio> findAll();

}
