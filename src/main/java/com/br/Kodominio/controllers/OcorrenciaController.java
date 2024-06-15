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
    public ResponseEntity<List<Ocorrencia>> listarOcorrencia(){
        List<Ocorrencia> list = dao.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/listar/{id}")
    @CrossOrigin
    public ResponseEntity<Optional<Ocorrencia>> getOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = service.getOcorrencia(id);
        return ResponseEntity.ok(Ocorrencia);
    }

    @GetMapping("/listar/condominio/{condominio}")
    @CrossOrigin
    public ResponseEntity<List<Ocorrencia>> condominioOcorrencias(@PathVariable Integer idCondominio){
        List<Ocorrencia> ocoCondo = service.listarCondominio(idCondominio);
        return ResponseEntity.ok(ocoCondo);
    }

    @GetMapping("/listar/usuario/{idUsuario}")
    public ResponseEntity<List<Ocorrencia>> usuarioOcorrencias(@PathVariable Long idUsuario){
        List<Ocorrencia> ocoUser = service.listarUsuario(idUsuario);
        return ResponseEntity.ok(ocoUser);
    }


    @GetMapping("/listar/datahora/{datahora}")
    @CrossOrigin
    public ResponseEntity<List<Ocorrencia>> horaOcorrencias(@PathVariable Timestamp datahora){
        List<Ocorrencia> ocoHora = service.listarDataHora(datahora);
        return ResponseEntity.ok(ocoHora);
    }


    @PostMapping("/inserir")
    @CrossOrigin
    public ResponseEntity<Ocorrencia> criarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia ocorrenciaCreate = service.inserirOcorrencia(ocorrencia);
        return ResponseEntity.ok(ocorrenciaCreate);
    }

    @PutMapping("/editar")
    @CrossOrigin
    public ResponseEntity<Ocorrencia> editarOcorrencia(@RequestParam String bocorrencia, Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaEdit = service.editarOcorrencia(bocorrencia, ocorrencia);
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
