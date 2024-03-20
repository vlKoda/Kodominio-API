package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IPorteiro;
import com.br.Kodominio.modelos.entidades.Porteiro;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/porteiro")
@Data
public class PorteiroController {

    @Autowired
    private IPorteiro dao;

    @GetMapping
    public List<Porteiro> listarPorteiro() {
        return (List<Porteiro>) dao.findAll();
    }

    @PostMapping("/cadastrar")
    public Porteiro criarPorteiro(@RequestBody Porteiro porteiro){
        Porteiro porteiroCreate = dao.save(porteiro);
        return porteiroCreate;
    }

    @PutMapping("/editar")
    public Porteiro editarPorteiro(@RequestParam String nome, @RequestParam String email, @RequestParam String senha,
                                   @RequestParam String telefone, @RequestParam String condominio, Porteiro porteiro){
        Porteiro porteiroEdit = dao.save(porteiro);
        return porteiroEdit;
    }

    @DeleteMapping
    public Optional<Porteiro> deletarPorteiro(@PathVariable Integer id){
        Optional<Porteiro> Porteiro = dao.findById(id);
        dao.deleteById(id);
        return Porteiro;
    }

}
