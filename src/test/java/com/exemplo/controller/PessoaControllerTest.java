package com.exemplo.controller;

import com.exemplo.dto.PessoaDTO;
import com.exemplo.model.Pessoa;
import com.exemplo.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class PessoaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaController).build();
    }

    @Test
    public void getAllPessoasTest() throws Exception {
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId("1");
        pessoa1.setNomeCompleto("Fulano de Tal");
        pessoa1.setDataNascimento("01/01/1990");
        pessoas.add(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId("2");
        pessoa2.setNomeCompleto("Ciclano da Silva");
        pessoa2.setDataNascimento("02/02/1991");
        pessoas.add(pessoa2);

        when(pessoaService.getAllPessoas()).thenReturn(pessoas);

        mockMvc.perform(get("/api/pessoas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].nomeCompleto").value("Fulano de Tal"))
                .andExpect(jsonPath("$[1].nomeCompleto").value("Ciclano da Silva"));
    }

    // Outros testes para getPessoaById, createPessoa, updatePessoa e deletePessoa
}
