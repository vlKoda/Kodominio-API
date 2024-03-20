package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Morador;
import org.springframework.data.repository.CrudRepository;

public interface IMorador extends CrudRepository<Morador, Integer> {
}
