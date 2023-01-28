package com.Attornatus.desafio.controllers;

import com.Attornatus.desafio.ResourceNotFoundException;
import com.Attornatus.desafio.entities.Endereco;
import com.Attornatus.desafio.entities.Pessoa;
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
@RequestMapping("/api")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/enderecos")
    public List<Endereco> getAllEnderecos() { return  enderecoRepository.findAll();

    }

    @GetMapping("/enderecos/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("endereco não encontrado"));
        return ResponseEntity.ok(endereco);
    }

    @PostMapping("/enderecos")
    public Endereco createEndereco(@RequestBody Endereco endereco) {
        Pessoa pessoa = pessoaRepository.findById(endereco.getPessoa().getId()).get();
        endereco.setPessoa(pessoa);

        return enderecoRepository.save(endereco);
    }

    @PutMapping("/enderecos/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco enderecoDetails) {

        Endereco endereco =  enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("endereco não encontrado"));

        Pessoa pessoa = pessoaRepository.findById(enderecoDetails.getPessoa().getId()).get();

        endereco.setLagradouro(enderecoDetails.getLagradouro());
        endereco.setNumCasa(enderecoDetails.getNumCasa());
        endereco.setCidade(enderecoDetails.getCidade());
        endereco.setCep(enderecoDetails.getCep());
        endereco.setEndPrincipal(enderecoDetails.getEndPrincipal());
        endereco.setPessoa(pessoa);

        Endereco newEndereco = enderecoRepository.save(endereco);

        return ResponseEntity.ok(newEndereco);
    }

    @DeleteMapping("/enderecos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEndereco(@PathVariable Long id) {

    Endereco endereco = enderecoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("endereco inexistente"));

    enderecoRepository.delete(endereco);
    Map<String, Boolean> response = new HashMap<>();
    response.put("endereco deletado", Boolean.TRUE);
    return ResponseEntity.ok(response);
    }

}
