package com.proj.planejador;

import com.proj.planejador.entity.Pessoa;
import com.proj.planejador.repository.PessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PessoaControllerTests {

    @Autowired
    private PessoaRepository pessoaRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("Testando o caminho feliz do salvar pessoa")
    @Test
    void testSalvar() throws Exception {
        String nome = "Primeira";
        int atributo = 2;

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/pessoa?nome=" + nome + "&atributo="+ atributo ).toString(), String.class);
        Pessoa result = pessoaRepository.findByNome(nome);
        assertEquals(nome, result.getNome());
        pessoaRepository.delete(result);
    }

}
