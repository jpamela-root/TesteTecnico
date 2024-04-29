package com.exemplo.service;

import com.exemplo.model.Pessoa;
import com.exemplo.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    private List<Pessoa> pessoas;

    @BeforeEach
    void setUp() {
        pessoas = new ArrayList<>();
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
    }

    @Test
    public void getAllPessoasTest() {
        when(pessoaRepository.findAll()).thenReturn(pessoas);
        List<Pessoa> pessoasRetornadas = pessoaService.getAllPessoas();
        assertEquals(2, pessoasRetornadas.size());
    }

    @Test
    public void getPessoaByIdTest() {
        String id = "1";
        Optional<Pessoa> pessoaOptional = Optional.of(pessoas.get(0));
        when(pessoaRepository.findById(id)).thenReturn(pessoaOptional);
        Pessoa pessoaRetornada = pessoaService.getPessoaById(id);
        assertEquals("Fulano de Tal", pessoaRetornada.getNomeCompleto());
    }

    // Outros testes para createPessoa, updatePessoa e deletePessoa
}
