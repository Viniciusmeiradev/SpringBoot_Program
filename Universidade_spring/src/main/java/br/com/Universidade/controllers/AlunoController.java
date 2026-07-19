package br.com.Universidade.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView inserirAluno(Aluno aluno){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("redirect:/Aluno/listAlunos");
        alunorepositorio.save(aluno);
        return mv;
    }
}