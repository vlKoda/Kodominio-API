package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IOcorrencia;
import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/ocorrencia")
@Data
public class OcorrenciaController {

    @Autowired
    private IOcorrencia dao;

    @GetMapping
    public List<Ocorrencia> listarOcorrencia(){
        return (List<Ocorrencia>) dao.findAll();
    }

    @PostMapping("/inserir")
    public Ocorrencia criarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia ocorrenciaCreate = dao.save(ocorrencia);
        return ocorrenciaCreate;
    }

    @PutMapping("/editar")
    public Ocorrencia editarOcorrencia(@RequestParam String bocorrencia, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaEdit = dao.save(ocorrencia);
        return ocorrenciaEdit;
    }

    @DeleteMapping
    public Optional<Ocorrencia> deletarOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        dao.deleteById(id);
        return Ocorrencia;
    }
}
