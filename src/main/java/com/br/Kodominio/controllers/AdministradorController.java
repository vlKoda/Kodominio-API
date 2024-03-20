package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IAdministrador;

import com.br.Kodominio.modelos.entidades.Administrador;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/administrador")
@Data
public class AdministradorController {

    @Autowired
    private IAdministrador dao;

    @GetMapping
    public List<Administrador> listarAdministrador(){
        return (List<Administrador>) dao.findAll();
    }

    @CrossOrigin
    @PostMapping("/cadastrar")
    public Administrador criarAdministrador(@RequestBody Administrador administrador){
        Administrador administradorCreate = dao.save(administrador);
        return administradorCreate;
    }

    @PutMapping
    public Administrador editarAdministrador(@RequestParam String nome, @RequestParam String email,
                                             @RequestParam String senha, @RequestParam String telefone, @RequestParam String condominio, Administrador administrador){
        Administrador administradorEdit = dao.save(administrador);
        return administradorEdit;
    }

    @DeleteMapping
    public Optional<Administrador> deletarAdministrador(@PathVariable Integer id){
        Optional<Administrador> Adminstrador = dao.findById(id);
        dao.deleteById(id);
        return Adminstrador;
    }

}
