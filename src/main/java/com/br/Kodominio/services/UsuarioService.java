package com.br.Kodominio.services;

import com.br.Kodominio.dao.IUsuario;
import com.br.Kodominio.modelos.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuario dao;

    public Usuario editarUsuario(@RequestBody Usuario usuario){
        return dao.save(usuario);
    }

    public List<Usuario> listarUsuario(){
        return (List<Usuario>) dao.findAll();
    }

    public Optional<Usuario> listarPorId(@PathVariable Long id){
        return dao.findById(id);
    }

    public List<Usuario> listarPorCondominio(@PathVariable Integer idCondominio){
        return dao.findAllByCondominioId(idCondominio);
    }

    public Optional<Usuario> deletarUsuario(@PathVariable Long id){
        Optional<Usuario> usuario = dao.findById(id);
        dao.deleteById(id);
        return usuario;
    }


}
