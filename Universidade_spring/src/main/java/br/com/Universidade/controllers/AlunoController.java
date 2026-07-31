package br.com.Universidade.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import br.com.Universidade.model.Aluno;
import br.com.Universidade.dao.AlunoDao;

@Controller
public class AlunoController {

    @Autowired
    private AlunoDao alunorepositorio;

    @GetMapping("/inserirAlunos")
    public ModelAndView InsertAlunos(Aluno aluno ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formAluno");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("InsertAlunos")
    public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br){
        ModelAndView mv= new ModelAndView();
        if(br.hasError()){
            mv.setViewName("formAluno");
            mv.addObject("aluno");
        }else{
            mv.setViewName("redirect:/alunos-adicionados");
            alunorepositorio.save(aluno);
        }
        return mv;
    }

    @GetMapping("alunos-adicionados")
    public ModelAndView listagemAlunos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/listAlunos");
        mv.addObject("alunosList", alunorepositorio.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alterar");
        Aluno aluno = alunorepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        mv.addObject("aluno", aluno);
        return mv;
    }

    @PostMapping("alterar")
    public ModelAndView alterar(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        alunorepositorio.save(aluno);
        mv.setViewName("redirect:/alunos-adicionados");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable("id") Integer id){
        alunorepositorio.deleteById(id);
        return "redirect:/alunos-adicionados";
    }

    @GetMapping("filtro-alunos")
    public ModelAndView filtroAlunos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("filtroAlunos");
        return mv;
    }


    @GetMapping("alunos-ativos")
    public ModelAndView listaAlunosAtivos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos-ativos");
        mv.addObject("alunosAtivos", alunorepositorio.findByStatusAtivos());
        return mv;
    }


    @GetMapping("alunos-inativos")
    public ModelAndView listaAlunosInativos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos-inativos");
        mv.addObject("alunosInativos", alunorepositorio.findByStatusInativo());
        return mv;
    }

    @GetMapping("alunos-cancelados")
    public ModelAndView listaAlunosCancelados(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos-cancelados");
        mv.addObject("alunosCancelados", alunorepositorio.findByStatusCancelado());
        return mv;
    }

    @GetMapping("alunos-trancados")
    public ModelAndView listaAlunosTrancados(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos-trancados");
        mv.addObject("alunosTrancados", alunorepositorio.findByStatusTrancados());
        return mv;
    }

    @PostMapping("pesquisar-aluno")
    public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome){
        ModelAndView mv = new ModelAndView();
        List<Aluno>listaAlunos;
        if (nome == null || nome.trim().isEmpty()){
            listaAlunos = alunorepositorio.findAll();
        }else{
            listaAlunos = alunorepositorio.findByNomeContainingIgnoreCase(nome);
        } 
        mv.addObject("ListaDeAlunos", listaAlunos);
        mv.setViewName("pesquisa-resultado");
        return mv;
    }
}

