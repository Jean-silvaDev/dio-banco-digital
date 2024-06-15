package edu.dio.banco.exceptions;

public class ValorException extends Exception {
	private static final long serialVersionUID = 1L;

	public ValorException() {
		super("Saldo insuficiente!");
	}
	
	public ValorException(double valor) {
		super(String.format("O valor passado não ser negativo ou igual a zero!\nValor passado %f!", valor));
	}
}
