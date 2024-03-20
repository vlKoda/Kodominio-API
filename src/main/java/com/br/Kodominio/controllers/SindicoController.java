package com.br.Kodominio.controllers;


import com.br.Kodominio.dao.ISindico;

import com.br.Kodominio.modelos.entidades.Sindico;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/sindico")
@Data
public class SindicoController {

    @Autowired
    private ISindico dao;

    @GetMapping
    public List<Sindico> listarSindico(){
        return (List<Sindico>) dao.findAll();
    }

    @PostMapping("/cadastrar")
    public Sindico criarSindico(@RequestBody Sindico sindico){
        Sindico sindicoCreate = dao.save(sindico);
        return sindicoCreate;
    }

    @PutMapping("/editar")
    public Sindico editarSindico(@RequestParam String nome, @RequestParam String email, @RequestParam String senha,
                                 @RequestParam String telefone, @RequestParam String condominio, Sindico sindico){
        Sindico sindicoEdit = dao.save(sindico);
        return sindicoEdit;
    }

    @DeleteMapping
    public Optional<Sindico> deletarSindico(@PathVariable Integer id){
        Optional<Sindico> Sindico = dao.findById(id);
        dao.deleteById(id);
        return Sindico;
    }
}
