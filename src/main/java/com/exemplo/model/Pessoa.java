package com.exemplo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Pessoa {

    @Id
    private String id;
    private String nomeCompleto;
    private String dataNascimento;

    @DBRef
    private List<Endereco> enderecos;

    @DBRef
    private Endereco enderecoPrincipal;

    // Getters e Setters
}
