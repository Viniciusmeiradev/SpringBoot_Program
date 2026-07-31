package br.com.Universidade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Universidade.model.Aluno;

public interface AlunoDao extends JpaRepository <Aluno, Integer>{
    @Query("select c from Aluno c where c.status = 'ATIVO' ")
    public List<Aluno> findByStatusAtivos();

    @Query("select c from Aluno c where c.status = 'INATIVO' ")
    public List<Aluno> findByStatusInativo();

    @Query("select c from Aluno c where c.status = 'CANCELADO' ")
    public List<Aluno> findByStatusCancelado();

    @Query("select c from Aluno c where c.status = 'TRANCADOS' ")
    public List<Aluno> findByStatusTrancado();
    
    public List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
