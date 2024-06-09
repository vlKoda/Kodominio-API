package com.br.Kodominio.services;

import com.br.Kodominio.dao.ICondominio;
import com.br.Kodominio.modelos.entidades.Condominio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CondominioService {

    @Autowired
    private ICondominio dao;

    public Condominio cadastrar(@RequestBody Condominio condominio){
        return dao.save(condominio);
    }

    public List<Condominio> listarCondominio(){
        return (List<Condominio>) dao.findAll();
    }

    public Condominio editarCondominio(@RequestBody Condominio condominio){
        Condominio condominioEdit = dao.save(condominio);
        return condominioEdit;
    }

    public Optional<Condominio> deletarCondominio(@PathVariable Integer id){
        Optional<Condominio> condominio = dao.findById(id);
        dao.deleteById(id);
        return condominio;
    }
}
