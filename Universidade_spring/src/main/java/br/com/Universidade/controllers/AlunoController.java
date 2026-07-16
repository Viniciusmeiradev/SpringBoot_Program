package br.com.Universidade.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.Universidade.model.Aluno;

@Controller
public class AlunoController {

    @GetMapping("/inserirAlunos")
    public ModelAndView InsertAlunos(Aluno aluno ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formAluno");
        mv.addObject("aluno", new Aluno());
        return mv;
    }
}