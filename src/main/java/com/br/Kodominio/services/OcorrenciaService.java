package com.br.Kodominio.services;

import com.br.Kodominio.dao.IOcorrencia;
import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private IOcorrencia dao;

    public Ocorrencia inserirOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return dao.save(ocorrencia);
    }

    public Ocorrencia editarOcorrencia(@PathVariable Integer id, @RequestParam(value = "status", required = false) String status,
                                       @RequestParam(value = "aprovacao", required = false) String aprovacao,
                                       @RequestParam(value = "prioridade", required = false) String prioridade){

        // Verificar se a ocorrência existe no banco de dados
        Optional<Ocorrencia> ocorrenciaOptional = dao.findById(id);

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
        return ocorrenciaAtualizada;
    }

    public Optional<Ocorrencia> deletarOcorrencia(@PathVariable Integer id){
        Optional<Ocorrencia> Ocorrencia = dao.findById(id);
        dao.deleteById(id);
        return Ocorrencia;
    }

    public List<Ocorrencia> findAll(){
        return (List<Ocorrencia>) dao.findAll();
    }

    public Optional<Ocorrencia> getOcorrencia(@PathVariable Integer id){
        return (Optional<Ocorrencia>) dao.findById(id);
    }

    public List<Ocorrencia> listarUsuario(@PathVariable Long idUsuario){
        return (List<Ocorrencia>) dao.findAllByUsuarioId(idUsuario);
    }

    public List<Ocorrencia> listarCondominio(@PathVariable Integer idCondominio){
        return (List<Ocorrencia>) dao.findAllByCondominioId(idCondominio);
    }

    public List<Ocorrencia> listarDataHora(@PathVariable Timestamp datahora){
        return (List<Ocorrencia>) dao.findAllByDatahora(datahora);
    }

}
