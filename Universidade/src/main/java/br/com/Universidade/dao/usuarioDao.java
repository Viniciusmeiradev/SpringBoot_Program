package br.com.Universidade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import br.com.Universidade.model.Usuario;

public interface UsuarioDao extends JpaRepository <Usuario, Long>{
    public List<Usuario> findByEmail();
}