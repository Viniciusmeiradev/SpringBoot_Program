package br.com.Universidade.Exceptions;

public class CriptoExistException extends Exception{
    public CriptoExistException(String message){
        super(message);
    }
    private static final long serialVersionUID=1L;
}