package com.proj.planejador.service;

import com.proj.planejador.entity.Pessoa;
import com.proj.planejador.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

}
