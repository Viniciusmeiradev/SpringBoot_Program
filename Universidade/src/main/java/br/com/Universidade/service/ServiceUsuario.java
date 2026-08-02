package br.com.Universidade.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.Universidade.dao.UsuarioDao;
import br.com.Universidade.model.Usuario;

@Service
public class ServiceUsuario{

    @Autowired
    private UsuarioDao usuarioRepositorio;

    public void salvarUsuario(Usuario user) throws Exception{
        try{
            if(usuarioRepositorio.findByEmail() != null){
                throw new EmailExistsException("Já existe um email cadastrado para: " + user.getEmail());
            }
            user.setSenha(Util.md5(user.getSenha());)
        }catch (Exception e){
            throw new CriptoExistException("Erro na criptografia da senha.");
        }

        usuarioRepositorio.save(user);
    }
}