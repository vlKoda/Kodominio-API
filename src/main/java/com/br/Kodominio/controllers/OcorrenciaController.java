package com.br.Kodominio.controllers;

import com.br.Kodominio.dao.IOcorrencia;
import com.br.Kodominio.modelos.entidades.Condominio;
import com.br.Kodominio.modelos.entidades.Usuario;
import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        if (Ocorrencia.isPresent()){
            return ResponseEntity.ok(Ocorrencia.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar/condominio/{idCondominio}")
    @CrossOrigin
    public ResponseEntity<?> condominioOcorrencias(@PathVariable Integer idCondominio){
        List<Ocorrencia> ocoCondo = dao.findAllByCondominioId(idCondominio);
        if (ocoCondo.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(ocoCondo);
        }
    }


    @GetMapping("/listar/datahora/{datahora}")
    @CrossOrigin
    public ResponseEntity<?> horaOcorrencias(@PathVariable Timestamp datahora){
        List<Ocorrencia> ocoHora = dao.findAllByDatahora(datahora);

        if (ocoHora.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(ocoHora);
        }
    }

    @GetMapping("/listar/usuario/{idUsuario}")
    @CrossOrigin
    public ResponseEntity<?> usuarioIdOcorrencia(@PathVariable Long idUsuario){
        List<Ocorrencia> ocoUser = dao.findAllByUsuarioId(idUsuario);
        if (ocoUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(ocoUser);
        }
    }

    @PostMapping("/inserir")
    @CrossOrigin
    public Ocorrencia criarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia ocorrenciaCreate = dao.save(ocorrencia);
        return ocorrenciaCreate;
    }

    @PutMapping("/editar/{id}")
    @CrossOrigin
    public ResponseEntity<Ocorrencia> editarOcorrencia(@PathVariable Integer id, @RequestBody Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaEdit = dao.save(ocorrencia);
        return ResponseEntity.ok(ocorrenciaEdit);
    }

    @PutMapping("/status/{id}")
    @CrossOrigin
    public Ocorrencia statusOcorrencia(@PathVariable Integer id, @RequestBody String status, Ocorrencia ocorrencia){
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

    @DeleteMapping("/{id}")
    @CrossOrigin
    public Optional<Ocorrencia> deletarOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        dao.deleteById(id);
        return Ocorrencia;
    }
}
