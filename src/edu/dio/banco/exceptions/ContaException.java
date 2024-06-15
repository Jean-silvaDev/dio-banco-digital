package edu.dio.banco.exceptions;

public class ContaException extends Exception{
	private static final long serialVersionUID = 1L;

	public ContaException() {
		super("A conta não pode ser nula!");
	}
}
