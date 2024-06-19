package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Condominio;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ICondominio extends CrudRepository<Condominio, Integer> {

    @EntityGraph(attributePaths = "ocorrencias")
    @Query("select distinct c from Condominio c left join fetch c.usuarios left join fetch c.ocorrencias")
    List<Condominio> findAll();

    @Query("select distinct c from Condominio c left join fetch c.usuarios left join fetch c.ocorrencias where c.id = :id")
    Optional<Condominio> findById(@Param("id") Integer id);
}
