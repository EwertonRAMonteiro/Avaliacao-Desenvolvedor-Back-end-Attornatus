package com.Attornatus.desafio.repositories;

import com.Attornatus.desafio.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repositorio extendido do jpa para entidade pessoa
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
