package com.exemplo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Endereco {

    @Id
    private String id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String estado;

    // Getters e Setters
}
