package com.Attornatus.desafio.repositories;

import com.Attornatus.desafio.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repositorio extendido do jpa para entidade endereco
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {}
