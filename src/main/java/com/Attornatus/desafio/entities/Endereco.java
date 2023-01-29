package com.Attornatus.desafio.entities;

import com.Attornatus.desafio.dto.EnderecoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//criando entendidade endereco
@Entity
@Table(name="Endereco")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name = "logradouro", nullable = false, length = 45)
    private String logradouro;

    @Column(name = "numeroCasa", nullable = false, length = 5)
    private String numCasa;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;

    @Column(name = "cidade", nullable = false, length = 30)
    private String cidade;

    @Column(name = "endPrincipal", nullable = false)
    private Boolean endPrincipal;

    // relacionamento entre a tabela pessoa
    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    //criando builder para dto
    public static Endereco of(EnderecoRequest request) {
        return Endereco
                .builder()
                .logradouro(request.getLogradouro())
                .numCasa(request.getNumCasa())
                .cep(request.getCep())
                .cidade(request.getCidade())
                .endPrincipal(request.getEndPrincipal())
                .pessoa(new Pessoa(request.getPessoaId()))
                .build();
    }
}
