package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import org.springframework.data.repository.CrudRepository;

public interface IOcorrencia extends CrudRepository<Ocorrencia, Integer> {

}
