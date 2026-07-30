package br.com.Universidade.model;
import br.com.Universidade.Enums.Curso;
import br.com.Universidade.Enums.Status;
import br.com.Universidade.Enums.Turno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    @Size(min=3, max=40, message="Deve conter no mínimo 3 caracteres.")
    @NotBlank(message = "Não pode ser vazio!")
    private String nome;

    @Column(name = "curso")
    @Enumerated(EnumType.STRING)
    @NotNull(message="Não pode ser vazio!")
    private Curso curso;

    @Column(name = "matricula")
    @Size(min=3, message("Clique no botão gerar matricula."))
    private String matricula;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull(message="Não pode ser vazio!")
    private Status status;

    @Column(name = "turno")
    @Enumerated(EnumType.STRING)
    @NotBlank(message="Não pode ser vazio.")
    private Turno turno;



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

    public Turno getTurno(){
        return turno;
    }
    public void setTurno(Turno turno){
        this.turno = turno;
    }
}
