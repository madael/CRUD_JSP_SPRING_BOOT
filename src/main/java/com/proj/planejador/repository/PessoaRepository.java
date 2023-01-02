package com.proj.planejador.repository;

import com.proj.planejador.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT t FROM Pessoa t WHERE t.nome = ?1")
    Pessoa findByNome(String nome);
}
