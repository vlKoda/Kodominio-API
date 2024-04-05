package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Condominio;
import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@EnableJpaRepositories
public interface IOcorrencia extends CrudRepository<Ocorrencia, Integer> {


   List<Ocorrencia> findAllByCondominio(Condominio id);

    //List<Ocorrencia> findAllByData(Timestamp data);
}
