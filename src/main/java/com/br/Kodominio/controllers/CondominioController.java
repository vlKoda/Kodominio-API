package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.ICondominio;

import com.br.Kodominio.modelos.entidades.Condominio;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/condominio")
@Data
public class CondominioController {

    @Autowired
    private ICondominio dao;

    @GetMapping("/listar")
    public List<Condominio> listarCondominio() {
        return (List<Condominio>) dao.findAll();
    }

    @PostMapping("/cadastrar")
    public Condominio criarCondominio(@RequestBody Condominio condominio){
        Condominio condominioCreate = dao.save(condominio);
        return condominioCreate;
    }

    @PutMapping("/editar")
    public Condominio editarCondominio(@RequestParam String nome, @RequestParam String rua, @RequestParam Integer numero,
                                       @RequestParam String bairro, @RequestParam String cidade, @RequestParam String estado,
                                       @RequestParam Integer cep, Condominio condominio){
        Condominio condominioEdit = dao.save(condominio);
        return condominioEdit;
    }

    @DeleteMapping
    public Optional<Condominio> deletarCondominio(@PathVariable Integer id){
        Optional<Condominio> Condominio = dao.findById(id);
        dao.deleteById(id);
        return Condominio;
    }




}
