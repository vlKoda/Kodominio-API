package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Porteiro;
import org.springframework.data.repository.CrudRepository;

public interface IPorteiro extends CrudRepository<Porteiro, Integer> {
}
