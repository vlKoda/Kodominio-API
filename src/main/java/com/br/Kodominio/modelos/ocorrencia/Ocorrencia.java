package com.br.Kodominio.modelos.ocorrencia;


import com.br.Kodominio.modelos.entidades.Condominio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "apartamento", nullable = false)
    private String apartamento;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ocorrencia", nullable = false)
    private String bocorrencia;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "prioridade", nullable = false)
    private String prioridade;

    @Column(name = "aprovacao", nullable = false)
    private String aprovacao;

    @ManyToOne
    @JoinColumn(name = "id_condominio")
    private Condominio condominio;

    // @Column(name = "data")
    // @CreationTimestamp
    // private Date data;

    @Column(name = "datahora")
    @CreationTimestamp
    private Timestamp datahora;

    @Column(name = "datahora_editada")
    @UpdateTimestamp
    private Timestamp datahora_editada;

    @PrePersist
    protected void onCreate(){
        if (this.status == null){
            this.status = 0;
        }
    }



}
