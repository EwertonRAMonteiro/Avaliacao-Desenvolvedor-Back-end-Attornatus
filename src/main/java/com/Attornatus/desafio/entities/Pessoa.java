package com.Attornatus.desafio.entities;

import com.Attornatus.desafio.dto.PessoaRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//criando entidade endereco
@Entity
@Table(name="pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "dataNasc", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNasc;

    //criando relacionamento para endereco
    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public Pessoa(Long id){
        this.id = id;
    }

    //criando builder para dto
    public static Pessoa of(PessoaRequest request) {
        return Pessoa
                .builder()
                .nome(request.getNome())
                .dataNasc(request.getDataNasc())
                .build();
    }
}
