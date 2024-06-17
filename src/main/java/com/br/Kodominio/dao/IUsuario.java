package com.br.Kodominio.dao;

import com.br.Kodominio.modelos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface IUsuario extends CrudRepository<Usuario, Long> {
    UserDetails findByEmail(String email);

    Optional<Usuario> findById(Long id);

    @Query("select distinct u from Usuario u join fetch u.condominio")
    List<Usuario> findAllByCondominioId(Integer idCondominio);


}
