package com.Attornatus.desafio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="Endereco")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Endereco extends Pessoa implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name = "lagradouro", nullable = false, length = 45)
    private String lagradouro;

    @Column(name = "numeroCasa", nullable = false, length = 5)
    private String numCasa;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;

    @Column(name = "cidade", nullable = false, length = 30)
    private String cidade;

    @Column(name = "endPrincipal", nullable = false)
    private Boolean endPrincipal;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    public 
}
