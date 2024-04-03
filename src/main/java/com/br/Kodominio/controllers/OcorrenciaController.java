package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IOcorrencia;
import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/ocorrencia")
@Data
public class OcorrenciaController {

    @Autowired
    private IOcorrencia dao;

    @GetMapping
    @CrossOrigin
    public List<Ocorrencia> listarOcorrencia(){
        return (List<Ocorrencia>) dao.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Optional<Ocorrencia> getOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        return Ocorrencia;
    }

    @GetMapping("/{condominio}")
    @CrossOrigin
    public List<Ocorrencia> condominioOcorrencias(@PathVariable Integer id){
        List<Ocorrencia> ocoCondo = dao.findAllByCondominio_Id(id);
        return ocoCondo;
    }

    @GetMapping("/{datahora}")
    @CrossOrigin
    public List<Ocorrencia> horaOcorrencias(@PathVariable Timestamp datahora){
        List<Ocorrencia> ocoHora = dao.findAllByData(datahora);
        return ocoHora;
    }

    @PostMapping("/inserir")
    @CrossOrigin
    public Ocorrencia criarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia ocorrenciaCreate = dao.save(ocorrencia);
        return ocorrenciaCreate;
    }

    @PutMapping("/editar")
    @CrossOrigin
    public Ocorrencia editarOcorrencia(@RequestParam String bocorrencia, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaEdit = dao.save(ocorrencia);
        return ocorrenciaEdit;
    }

    @PutMapping("/status")
    @CrossOrigin
    public Ocorrencia statusOcorrencia(@RequestBody Integer status, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaStatus = dao.save(ocorrencia);
        return ocorrenciaStatus;
    }

    @DeleteMapping
    @CrossOrigin
    public Optional<Ocorrencia> deletarOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        dao.deleteById(id);
        return Ocorrencia;
    }
}
