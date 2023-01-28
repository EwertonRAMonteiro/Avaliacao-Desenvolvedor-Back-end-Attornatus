package com.Attornatus.desafio.repositories;

import com.Attornatus.desafio.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
