package com.br.Kodominio.modelos.ocorrencia;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "autor")
    private String autor;

    @Column(name = "email")
    private String email;

    @Column(name = "condominio")
    private String condominio;

    @Column(name = "ocorrencia")
    private String bocorrencia;

    @Column(name = "status")
    private Integer status;


}
