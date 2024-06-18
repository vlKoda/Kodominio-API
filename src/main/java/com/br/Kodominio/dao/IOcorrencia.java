package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Condominio;
import com.br.Kodominio.modelos.entidades.Usuario;
import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface IOcorrencia extends CrudRepository<Ocorrencia, Integer> {


   List<Ocorrencia> findAllByCondominioId(Integer idCondominio);

    List<Ocorrencia> findAllByDatahora(Timestamp datahora);

    @Query("select distinct o from Ocorrencia o left join fetch o.usuario join fetch o.condominio")
    List<Ocorrencia> findAll();

    List<Ocorrencia> findAllByUsuarioId(Long idUsuario);


}
