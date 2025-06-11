package br.com.alura.consultaCep.excecoes;

public class BuscaInvalidaException extends RuntimeException {
    public BuscaInvalidaException(String message) {
        super(message);
    }
}
