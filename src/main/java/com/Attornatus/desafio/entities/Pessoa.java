package com.Attornatus.desafio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "dataNasc", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNasc;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;
}
