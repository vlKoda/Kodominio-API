package com.br.Kodominio.modelos.ocorrencia;


import com.br.Kodominio.modelos.entidades.Condominio;
import com.br.Kodominio.modelos.entidades.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "ocorrencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ocorrencia", length = 255, nullable = false)
    private String bocorrencia;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "prioridade", nullable = false)
    private String prioridade;

    @Column(name = "aprovacao", nullable = false)
    private String aprovacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference("usuario-ocorrencias")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_condominio", nullable = false)
    @JsonBackReference("condominio-ocorrencias")
    private Condominio condominio;

    @Column(name = "datahora")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp datahora;

    @Column(name = "datahora_editada")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp datahora_editada;

    @PrePersist
    protected void onCreate(){
        if (this.status == null){
            this.status = "Em avaliação";
        }
        if (this.prioridade == null){
            this.prioridade = "Leve";
        }
        if (this.aprovacao == null){
            this.aprovacao = "Em andamento";
        }
    }



}
