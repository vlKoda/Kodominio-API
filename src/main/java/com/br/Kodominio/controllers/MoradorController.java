package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IMorador;
import com.br.Kodominio.modelos.entidades.Morador;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/morador")
@Data
public class MoradorController {

    @Autowired
    private IMorador dao;

    @GetMapping
    public List<Morador> listarMorador(){
        return (List<Morador>) dao.findAll();
    }

    @PostMapping("/cadastrar")
    public Morador criarMorador(@RequestBody Morador morador){
        Morador moradorCreate = dao.save(morador);
        return moradorCreate;
    }

    @PutMapping("/editar")
    public Morador editarMorador(@RequestParam String nome, @RequestParam String email, @RequestParam String senha,
                                 @RequestParam String telefone, @RequestParam String condominio, Morador morador){
        Morador moradorEdit = dao.save(morador);
        return moradorEdit;
    }

    @DeleteMapping
    public Optional<Morador> deletarMorador(@PathVariable Integer id){
        Optional<Morador> Morador = dao.findById(id);
        dao.deleteById(id);
        return Morador;
    }




}
