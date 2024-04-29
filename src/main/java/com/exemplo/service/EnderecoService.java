package com.exemplo.service;

import com.exemplo.dto.EnderecoDTO;
import com.exemplo.model.Endereco;
import com.exemplo.repository.EnderecoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(String id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco createEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return enderecoRepository.save(endereco);
    }

    public Endereco updateEndereco(String id, EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        if (endereco != null) {
            BeanUtils.copyProperties(enderecoDTO, endereco);
            return enderecoRepository.save(endereco);
        }
        return null;
    }

    public void deleteEndereco(String id) {
        enderecoRepository.deleteById(id);
    }
}
