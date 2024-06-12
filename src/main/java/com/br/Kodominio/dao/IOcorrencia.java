package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Condominio;
import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface IOcorrencia extends CrudRepository<Ocorrencia, Integer> {


   List<Ocorrencia> findAllByCondominio(Condominio id);

    List<Ocorrencia> findAllByDatahora(Timestamp datahora);

    //List<Ocorrencia> findAllByData(Date data);

    List<Ocorrencia> findAllByAutor(String autor);
}
