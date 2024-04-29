package com.exemplo.controller;

import com.exemplo.dto.EnderecoDTO;
import com.exemplo.model.Endereco;
import com.exemplo.service.EnderecoService;
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
public class EnderecoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EnderecoService enderecoService;

    @InjectMocks
    private EnderecoController enderecoController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(enderecoController).build();
    }

    @Test
    public void getAllEnderecosTest() throws Exception {
        List<Endereco> enderecos = new ArrayList<>();
        Endereco endereco1 = new Endereco();
        endereco1.setId("1");
        endereco1.setLogradouro("Rua A");
        endereco1.setCep("12345-678");
        endereco1.setNumero("123");
        endereco1.setCidade("Cidade A");
        endereco1.setEstado("Estado A");
        enderecos.add(endereco1);

        Endereco endereco2 = new Endereco();
        endereco2.setId("2");
        endereco2.setLogradouro("Rua B");
        endereco2.setCep("98765-432");
        endereco2.setNumero("456");
        endereco2.setCidade("Cidade B");
        endereco2.setEstado("Estado B");
        enderecos.add(endereco2);

        when(enderecoService.getAllEnderecos()).thenReturn(enderecos);

        mockMvc.perform(get("/api/enderecos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].logradouro").value("Rua A"))
                .andExpect(jsonPath("$[1].logradouro").value("Rua B"));
    }

    // Outros testes para getEnderecoById, createEndereco, updateEndereco e deleteEndereco
}
