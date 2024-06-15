package edu.dio.banco.interfaces;

import edu.dio.banco.Cliente;
import edu.dio.banco.exceptions.ClienteException;
import edu.dio.banco.exceptions.ValorException;

public interface IConta {
	public void sacar(double valor) throws ValorException;
	public void depositar(double valor) throws ValorException;
	public void transferir(double valor, Cliente cliente) throws ValorException, ClienteException;
	public Cliente encontrarCliente(Cliente cliente);
	public void imprimirExtrato();
}
