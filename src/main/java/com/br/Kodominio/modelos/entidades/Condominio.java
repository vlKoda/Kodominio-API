package com.br.Kodominio.modelos.entidades;



import com.br.Kodominio.modelos.ocorrencia.Ocorrencia;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of = "id_condominio")
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_condominio")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "rua", nullable = false, length = 200)
    private String rua;

    @Column(name = "numero", nullable = false, length = 4)
    private Short numero;

    @Column(name = "bairro", nullable = false, length = 200)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 200)
    private String cidade;

    @Column(name = "estado", nullable = false, length = 200)
    private String estado;

    @Column(name = "cep", length = 8)
    private Integer cep;

    @OneToMany(mappedBy = "id_condominio")
    private List<Ocorrencia> ocorrencias;

}
