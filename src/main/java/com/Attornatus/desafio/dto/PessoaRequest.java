package com.Attornatus.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// criando dto request para pessoa
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {

    private String nome;

    private Date dataNasc;

}
