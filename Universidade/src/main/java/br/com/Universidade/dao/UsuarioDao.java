package br.com.Universidade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import br.com.Universidade.model.Usuario;

public interface UsuarioDao extends JpaRepository <Usuario, Long>{

    @Query("select c from Usuario c where c.email = :email")
    public Usuario findByEmail( String email);

    @Query("select c from Usuario c where c.user = :user and c.senha = :senha")
    public Usuario buscarLogin(String user, String senha);
}