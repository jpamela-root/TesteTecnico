package com.exemplo.service;

import com.exemplo.dto.PessoaDTO;
import com.exemplo.model.Pessoa;
import com.exemplo.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoaById(String id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa updatePessoa(String id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        if (pessoa != null) {
            BeanUtils.copyProperties(pessoaDTO, pessoa);
            return pessoaRepository.save(pessoa);
        }
        return null;
    }

    public void deletePessoa(String id) {
        pessoaRepository.deleteById(id);
    }
}
