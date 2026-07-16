package br.com.Universidade.Enums;

public enum Curso {
    ADMINISTRACAO("Administracao"),
    DIREITO("Direito"),
    ARQUITETURA("Arquitetura"),
    MEDICINA("Medicina"),
    CONTABILIDADE("Contabilidade"),
    FISICA("Fisica");
    
    private String Curso;

    private Curso(String curso){
        this.curso = curso;
    }
}