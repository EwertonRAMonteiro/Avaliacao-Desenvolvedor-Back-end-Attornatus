package com.Attornatus.desafio.controllers;

import com.Attornatus.desafio.dto.PessoaRequest;
import com.Attornatus.desafio.entities.Pessoa;
import com.Attornatus.desafio.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Attornatus.desafio.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("pessoas")
    public List<Pessoa> getAllPessoas(){
        return pessoaRepository.findAll();
    }

    @GetMapping("pessoas/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person doesn't exist"));
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping("pessoas")
    public Pessoa createPessoa(@RequestBody PessoaRequest request){
        return pessoaRepository.save(Pessoa.of(request));
    }

    @PutMapping("pessoas/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody PessoaRequest request){
        pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person doesn't exist"));

        var pessoa = Pessoa.of(request);
        pessoa.setId(id);

        Pessoa newPessoa = pessoaRepository.save(pessoa);

        return ResponseEntity.ok(newPessoa);
    }

    @DeleteMapping("pessoas/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePessoa(@PathVariable Long id){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person doesn't exist"));

        pessoaRepository.delete(pessoa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
