package br.com.Universidade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Universidade.model.Aluno;

public interface AlunoDao extends JpaRepository <Aluno, Integer>{

}