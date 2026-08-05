package br.com.Universidade.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;

import br.com.Universidade.dao.UsuarioDao;
import br.com.Universidade.mode.Usuario;

@Controller
public class UsuarioController{

    @Autowired
    private UsuarioDao usuarioRepositorio;

    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping("/")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login/login");
        return mv;
    }

    @GetMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @GetMapping("/")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        mv.setViewName("Login/cadastro");
        return mv;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView cadastrar(Usuario usuario) throws Exception{
        ModelAndView mv = new ModelAndView();
        serviceUsuario.salvarUsuario(usuario);
        mv.setViewName("redirect:/");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExceptio{
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        if(br.hasErrors()){
            mv.setViewName("Login/login");
        }

        Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
        if (userLogin == null){
            mv.addObject("msg", "Usuário não encontrado. Tente Novamente!");
        }else{
            session.setAttribute("usuarioLogado", userLogin);
            return index();
        }

        return mv;
    }

    @PostMapping("/logout")
    public ModelAndView logout("HttpSession session"){
        session.invalidate();
        return login();
    }
}