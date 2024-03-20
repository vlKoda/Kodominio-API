package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Owner;
import org.springframework.data.repository.CrudRepository;

public interface IOwner extends CrudRepository<Owner, Integer> {
}
