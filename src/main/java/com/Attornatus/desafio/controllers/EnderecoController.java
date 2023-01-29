package com.Attornatus.desafio.controllers;

import com.Attornatus.desafio.ResourceNotFoundException;
import com.Attornatus.desafio.dto.EnderecoRequest;
import com.Attornatus.desafio.entities.Endereco;
import com.Attornatus.desafio.repositories.EnderecoRepository;
import com.Attornatus.desafio.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    //metodo listar enderecos
    @GetMapping("enderecos")
    public List<Endereco> getAllEnderecos() { return  enderecoRepository.findAll();

    }

    //metodo listar endereco por id
    @GetMapping("enderecos/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("endereco não encontrado"));
        return ResponseEntity.ok(endereco);
    }

    //metodo para criar novos endereços
    @PostMapping("enderecos")
    public Endereco createEndereco(@RequestBody EnderecoRequest request) {

        return enderecoRepository.save(Endereco.of(request));
    }

    //metodo atualizar
    @PutMapping("enderecos/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody EnderecoRequest request) {

       enderecoRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("endereco não encontrado"));

        var enderec = Endereco.of(request);
        enderec.setId(id);


        Endereco newEndereco = enderecoRepository.save(enderec);

        return ResponseEntity.ok(newEndereco);
    }

    //metodo deletar
    @DeleteMapping("enderecos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEndereco(@PathVariable Long id) {

    Endereco endereco = enderecoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("endereco inexistente"));

    enderecoRepository.delete(endereco);
    Map<String, Boolean> response = new HashMap<>();
    response.put("endereco deletado", Boolean.TRUE);
    return ResponseEntity.ok(response);
    }

    //metodo listar enderecos por pessoa com id
    @GetMapping("enderecos/pessoa/{id}")
    public ResponseEntity<List<Endereco>> encontrarTodoEnderecoDePessoa(@PathVariable("id") Long id) {

        var pessoa= pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("pessoa inexistente"));
        var enderecos = pessoa.getEnderecos();

        return ResponseEntity.ok(enderecos);
    }

}
