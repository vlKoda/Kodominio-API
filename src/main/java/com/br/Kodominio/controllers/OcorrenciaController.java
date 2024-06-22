package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IOcorrencia;
import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;

import com.br.Kodominio.services.OcorrenciaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/ocorrencia")
@Data
public class OcorrenciaController {

    @Autowired
    private IOcorrencia dao;

    @Autowired
    private OcorrenciaService service;

    @GetMapping("/listar")
    @CrossOrigin
    public ResponseEntity<?> listarOcorrencia(){
        List<Ocorrencia> list = dao.findAll();
        if(list.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(list);
        }
    }

    @GetMapping("/listar/{id}")
    @CrossOrigin
    public ResponseEntity<?> getOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = service.getOcorrencia(id);
        if(Ocorrencia.isPresent()){
            return ResponseEntity.ok(Ocorrencia);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar/condominio/{condominio}")
    @CrossOrigin
    public ResponseEntity<?> condominioOcorrencias(@PathVariable Integer idCondominio){
        List<Ocorrencia> ocoCondo = service.listarCondominio(idCondominio);
        if (ocoCondo.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(ocoCondo);
        }
    }

    @GetMapping("/listar/usuario/{idUsuario}")
    public ResponseEntity<?> usuarioOcorrencias(@PathVariable Long idUsuario){
        List<Ocorrencia> ocoUser = service.listarUsuario(idUsuario);
        if (ocoUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(ocoUser);
        }
    }


    @GetMapping("/listar/datahora/{datahora}")
    @CrossOrigin
    public ResponseEntity<?> horaOcorrencias(@PathVariable Timestamp datahora){
        List<Ocorrencia> ocoHora = service.listarDataHora(datahora);
        if (ocoHora.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(ocoHora);
        }
    }


    @PostMapping("/inserir")
    @CrossOrigin
    public ResponseEntity<Ocorrencia> criarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia ocorrenciaCreate = service.inserirOcorrencia(ocorrencia);
        return ResponseEntity.ok(ocorrenciaCreate);
    }

    @PutMapping("/editar/{id}")
    @CrossOrigin
    public ResponseEntity<Ocorrencia> editarOcorrencia(@PathVariable Integer id, @RequestBody Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaEdit = service.editarOcorrencia(ocorrencia);
        return ResponseEntity.ok(ocorrenciaEdit);
    }

    @PutMapping("/status")
    @CrossOrigin
    public ResponseEntity<Ocorrencia> statusOcorrencia(@RequestBody Integer status, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaStatus = service.setStatus(status, ocorrencia);
        return ResponseEntity.ok(ocorrenciaStatus);
    }

    @PutMapping("/prioridade")
    @CrossOrigin
    public ResponseEntity<Ocorrencia> prioridadeOcorrencia(@RequestBody String prioridade, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaPrioridade = service.setPrioridade(prioridade, ocorrencia);
        return ResponseEntity.ok(ocorrenciaPrioridade);
    }

    @PutMapping("/aprovacao")
    @CrossOrigin
    public ResponseEntity<Ocorrencia> aprovarOcorrencia(@RequestBody String aprovacao, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaAprovar = service.setAprovacao(aprovacao, ocorrencia);
        return ResponseEntity.ok(ocorrenciaAprovar);
    }

    @DeleteMapping("/deletar/{id}")
    @CrossOrigin
    public ResponseEntity<Optional<Ocorrencia>> deletarOcorrencia(@PathVariable Integer id){
        service.deletarOcorrencia(id);
        return ResponseEntity.noContent().build();
    }
}
