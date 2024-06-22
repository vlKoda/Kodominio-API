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
    public ResponseEntity<Ocorrencia> statusOcorrencia(
            @PathVariable Integer id,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "aprovacao", required = false) String aprovacao,
            @RequestParam(value = "prioridade", required = false) String prioridade) {

        // Verificar se a ocorrência existe no banco de dados
        Optional<Ocorrencia> ocorrenciaOptional = dao.findById(id);
        if (!ocorrenciaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Ocorrencia ocorrenciaStatus = ocorrenciaOptional.get();

        // Atualizar os valores de status e aprovacao se forem fornecidos
        if (status != null) {
            ocorrenciaStatus.setStatus(status);
        }
        if (aprovacao != null) {
            ocorrenciaStatus.setAprovacao(aprovacao);
        }
        if (prioridade != null){
            ocorrenciaStatus.setPrioridade(prioridade);
        }

        // Salvar a ocorrência atualizada
        Ocorrencia ocorrenciaAtualizada = dao.save(ocorrenciaStatus);
        return ResponseEntity.ok(ocorrenciaAtualizada);
    }


    @DeleteMapping("/{id}")
    @CrossOrigin
    public Optional<Ocorrencia> deletarOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        dao.deleteById(id);
        return Ocorrencia;
    }
}
