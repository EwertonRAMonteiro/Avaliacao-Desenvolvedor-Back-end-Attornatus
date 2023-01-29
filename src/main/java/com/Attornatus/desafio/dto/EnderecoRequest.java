package com.Attornatus.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    private String logradouro;


    private String numCasa;


    private String cep;


    private String cidade;


    private Boolean endPrincipal;

    private Long pessoaId;
}
