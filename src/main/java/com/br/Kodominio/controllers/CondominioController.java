package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.ICondominio;

import com.br.Kodominio.modelos.entidades.Condominio;

import com.br.Kodominio.services.CondominioService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/condominio")
@Data
public class CondominioController {

    @Autowired
    private ICondominio dao;

    @Autowired
    private CondominioService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listarCondominio() {
        List<Condominio> listaCondominio = service.listarCondominio();
        if(listaCondominio.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(listaCondominio);
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> condominioPorId(@PathVariable Integer id){
        Optional<Condominio> condoId = service.condominioPorId(id);
        if(condoId.isPresent()){
            return ResponseEntity.ok(condoId);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Condominio> criarCondominio(@RequestBody Condominio condominio){
        Condominio condominioCreate = service.cadastrar(condominio);
        return ResponseEntity.ok(condominioCreate);
    }

    @PutMapping("/editar")
    public ResponseEntity<Condominio> editarCondominio(@RequestBody Condominio condominio){
        Condominio condominioEdit = service.editarCondominio(condominio);
        return ResponseEntity.ok(condominioEdit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCondominio(@PathVariable Integer id){
        service.deletarCondominio(id);
        return ResponseEntity.noContent().build();
    }




}
