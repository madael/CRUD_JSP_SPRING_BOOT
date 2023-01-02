package com.proj.planejador.controller;

import com.proj.planejador.entity.Pessoa;
import com.proj.planejador.entity.Projeto;
import com.proj.planejador.enums.CargosEnum;
import com.proj.planejador.enums.StatusEnum;
import com.proj.planejador.enums.RiscoEnum;
import com.proj.planejador.model.EnumModel;
import com.proj.planejador.pipe.StatusPipe;
import com.proj.planejador.service.PessoaService;
import com.proj.planejador.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/projeto")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;
    @Autowired
    PessoaService pessoaService;

    @GetMapping("/")
    public String index(){
        return "listaProjeto";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam Long id){
        Projeto projeto = this.projetoService.getReferenceById(id);
        if(StatusPipe.canDelete(projeto.getStatus())){
            projetoService.delete(projeto);
        }else{
            System.out.println("Não pode apagar com status: " + projeto.getStatusTaduzido());
        }
        return "redirect:/projeto/";
    }

    @GetMapping("/editar")
    public ModelAndView editarForm(@RequestParam Long id) {
        Projeto projeto = this.projetoService.getReferenceById(id);
        return new ModelAndView("formularioProjeto", "projeto", projeto);
    }

    @PostMapping("/form")
    public String confirmarForm(@Valid @ModelAttribute("projeto") Projeto projeto, BindingResult result) {

        if (result.hasErrors()) {
            return "formularioProjeto";
        }

        projetoService.save(projeto);
        return "redirect:/projeto/";
    }


    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("projeto", new Projeto());
        return "formularioProjeto";
    }

    @ModelAttribute("projetos")
    public List<Projeto> getTodosProjetos(){
        return projetoService.findAll();
    }

    @ModelAttribute("listaRisco")
    public List<EnumModel> getTodosRisco(){
        return Arrays.asList(
               new EnumModel(RiscoEnum.BAIXO.name(), "Baixo"),
               new EnumModel(RiscoEnum.MEDIO.name(), "Médio"),
               new EnumModel(RiscoEnum.ALTO.name(), "Alto")
        );
    }

    @ModelAttribute("listaStatus")
    public List<EnumModel> getTodosStatus(){
        return Arrays.asList(
               new EnumModel(StatusEnum.ANALISANDO.name(), "Em análise"),
               new EnumModel(StatusEnum.ANALISE_REALIZADA.name(), "Análise realizada"),
               new EnumModel(StatusEnum.ANALISE_APROVADA.name(), "Análise aprovada"),
               new EnumModel(StatusEnum.INICIADO.name(), "Iniciado"),
               new EnumModel(StatusEnum.PLANEJADO.name(), "Planejado"),
               new EnumModel(StatusEnum.ANDAMENTO.name(), "Andamento"),
               new EnumModel(StatusEnum.ENCERRADO.name(), "Encerrado"),
               new EnumModel(StatusEnum.CANCELADO.name(), "Cancelado")
        );
    }

    @ModelAttribute("listaGerentes")
    public List<Pessoa> getTodosGerentes(){
        List<Pessoa> todasPessoas = pessoaService.findAll();
        return todasPessoas.stream().filter(item-> item.getCargo().equals(CargosEnum.GERENTE.name())).collect(Collectors.toUnmodifiableList());
    }

    @ModelAttribute("listaMembros")
    public List<Pessoa> getTodosFuncionarios(){
        List<Pessoa> todasPessoas = pessoaService.findAll();
        return todasPessoas.stream().filter(Pessoa::isFuncionario).collect(Collectors.toUnmodifiableList());
    }


}
