package edu.dio.banco.exceptions;

public class ClienteException extends Exception{
	private static final long serialVersionUID = 1L;

	public ClienteException() {
		super("O cliente não pode ser nulo!");
	}
}
