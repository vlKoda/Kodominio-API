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
    public ResponseEntity<Ocorrencia> editarOcorrencia(@PathVariable Integer id, @RequestParam(value = "status", required = false) String status,
                                                       @RequestParam(value = "aprovacao", required = false) String aprovacao, @RequestParam(value = "prioridade", required = false) String prioridade){
        Ocorrencia ocorrenciaEdit = service.editarOcorrencia(id, status, aprovacao, prioridade);
        return ResponseEntity.ok(ocorrenciaEdit);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Optional<Ocorrencia>> deletarOcorrencia(@PathVariable Integer id){
        service.deletarOcorrencia(id);
        return ResponseEntity.noContent().build();
    }
}
