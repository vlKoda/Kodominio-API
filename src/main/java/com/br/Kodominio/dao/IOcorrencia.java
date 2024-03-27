package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOcorrencia extends CrudRepository<Ocorrencia, Integer> {

    Object findAllById(Integer idcondominio);

    List<Ocorrencia> findAllByCondominio(String condiminio);

    List<Ocorrencia> findAllByCondominio_Id(Integer id);
}
