package com.proj.planejador.controller;

import com.proj.planejador.entity.Pessoa;
import com.proj.planejador.enums.CargosEnum;
import com.proj.planejador.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public void salvar (String nome, Integer atributo){
        String cargo = "";
        boolean isFuncionario = true;

        switch (atributo){
            case 1:
                isFuncionario = false;
                cargo = CargosEnum.TERCERIZADO.name();
                break;
            case 2:
                cargo = CargosEnum.GERENTE.name();
                break;
            case 3:
                cargo = CargosEnum.SUPERVISOR.name();
                break;
            case 4:
                cargo = CargosEnum.EXECUTOR.name();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + atributo);
        }

        Pessoa pessoa = new Pessoa(nome, cargo, isFuncionario);
        System.out.println("salvando pessoa " + pessoa.getNome());
        pessoaService.save(pessoa);
    }
}
