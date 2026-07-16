package br.com.Universidade.model;
import br.com.Universidade.Enums.Curso;
import br.com.Universidade.Enums.Status;

import javax.persistence.column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @column(name = "nome")
    private String nome;

    @column(name = "curso")
    private Curso curso;

    @column(name = "matricula")
    private String matricula;

    @column(name = "status")
    private Status status;

    @column(name = turno)
    private String turno;



    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public Curso getCurso(){
        return curso;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }
    
    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }

    public String getTurno(){
        return turno;
    }
    public void setTurno(String turno){
        this.turno = turno;
    }
}
