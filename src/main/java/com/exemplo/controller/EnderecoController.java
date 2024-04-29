package com.exemplo.controller;

import com.exemplo.dto.EnderecoDTO;
import com.exemplo.model.Endereco;
import com.exemplo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> getAllEnderecos() {
        return enderecoService.getAllEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable String id) {
        Endereco endereco = enderecoService.getEnderecoById(id);
        return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoService.createEndereco(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable String id, @RequestBody EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoService.updateEndereco(id, enderecoDTO);
        return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable String id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
