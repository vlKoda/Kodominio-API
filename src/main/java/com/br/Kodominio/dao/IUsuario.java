package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario, Integer> {

}
