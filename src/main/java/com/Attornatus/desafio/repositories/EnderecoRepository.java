package com.Attornatus.desafio.repositories;

import com.Attornatus.desafio.dto.EnderecoRequest;
import com.Attornatus.desafio.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {}
