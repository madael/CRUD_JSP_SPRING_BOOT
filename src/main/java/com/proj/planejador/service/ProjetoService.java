package com.proj.planejador.service;

import com.proj.planejador.entity.Projeto;
import com.proj.planejador.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;

    public void save(Projeto projeto) {
        projetoRepository.save(projeto);
    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public Projeto getReferenceById(Long id) {
        return projetoRepository.getReferenceById(id);
    }

    public void delete(Projeto projeto) {
        projetoRepository.delete(projeto);
    }

}
