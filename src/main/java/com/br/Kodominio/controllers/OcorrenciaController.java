package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IOcorrencia;
import com.br.Kodominio.modelos.entidades.Condominio;
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

    @GetMapping("/listar")
    @CrossOrigin
    public List<Ocorrencia> listarOcorrencia(){
        return (List<Ocorrencia>) dao.findAll();
    }

    @GetMapping("/listar/{id}")
    @CrossOrigin
    public Optional<Ocorrencia> getOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        return Ocorrencia;
    }

    @GetMapping("/listar/{condominio}")
    @CrossOrigin
    public List<Ocorrencia> condominioOcorrencias(@PathVariable Condominio id){
        List<Ocorrencia> ocoCondo = dao.findAllByCondominio(id);
        return ocoCondo;
    }

    /*
    @GetMapping("listar/{data}")
    @CrossOrigin
    public List<Ocorrencia> dataOcorrencia(@PathVariable Date data){
        List<Ocorrencia> dataOco = dao.findAllByData(data);
        return dataOco;
    }

     */

    @GetMapping("/listar/{datahora}")
    @CrossOrigin
    public List<Ocorrencia> horaOcorrencias(@PathVariable Timestamp datahora){
        List<Ocorrencia> ocoHora = dao.findAllByDatahora(datahora);
        return ocoHora;
    }

    @GetMapping("/listar/{autor}")
    @CrossOrigin
    public List<Ocorrencia> autorOcorrencia(@PathVariable String autor){
        List<Ocorrencia> ocoAutor = dao.findAllByAutor(autor);
        return ocoAutor;
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

    @PutMapping("/prioridade")
    @CrossOrigin
    public Ocorrencia prioridadeOcorrencia(@RequestBody String prioridade, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaPrioridade = dao.save(ocorrencia);
        return ocorrenciaPrioridade;
    }

    @PutMapping("/aprovacao")
    @CrossOrigin
    public Ocorrencia aprovarOcorrencia(@RequestBody String aprovacao, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaAprovar = dao.save(ocorrencia);
        return ocorrenciaAprovar;
    }

    @DeleteMapping
    @CrossOrigin
    public Optional<Ocorrencia> deletarOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        dao.deleteById(id);
        return Ocorrencia;
    }
}
