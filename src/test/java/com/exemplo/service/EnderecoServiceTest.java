
package com.exemplo.service;

import com.exemplo.model.Endereco;
import com.exemplo.repository.EnderecoRepository;
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
public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    private List<Endereco> enderecos;

    @BeforeEach
    void setUp() {
        enderecos = new ArrayList<>();
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
    }

    @Test
    public void getAllEnderecosTest() {
        when(enderecoRepository.findAll()).thenReturn(enderecos);
        List<Endereco> enderecosRetornados = enderecoService.getAllEnderecos();
        assertEquals(2, enderecosRetornados.size());
    }

    @Test
    public void getEnderecoByIdTest() {
        String id = "1";
        Optional<Endereco> enderecoOptional = Optional.of(enderecos.get(0));
        when(enderecoRepository.findById(id)).thenReturn(enderecoOptional);
        Endereco enderecoRetornado = enderecoService.getEnderecoById(id);
        assertEquals("Rua A", enderecoRetornado.getLogradouro());
    }

    // Outros testes para createEndereco, updateEndereco e deleteEndereco
}
