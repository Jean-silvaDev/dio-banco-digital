package edu.dio.banco;

import java.util.List;

import edu.dio.banco.exceptions.ClienteException;
import edu.dio.banco.exceptions.ValorException;
import edu.dio.banco.interfaces.IConta;

public abstract class Conta implements IConta {
	protected int agencia, numero;
	protected double saldo;
	protected Cliente cliente;
	private Banco banco;
	
	public Conta(int agencia, int numero, double saldo, Cliente cliente, Banco banco) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
		this.banco = banco;
	}
	
	@Override
	public void sacar(double valor) throws ValorException {
		if(valor < this.saldo)
			this.saldo -= valor;
		else
			throw new ValorException();
	}
	
	Cliente getCliente() {
		return this.cliente;
	}
	
	@Override
	public void depositar(double valor) throws ValorException {
		if(valor > 0)
			this.saldo += valor;
		else
			throw new ValorException(valor);
	}
	
	@Override
	public void transferir(double valor, Cliente cliente) throws ValorException, ClienteException {
		if(cliente == null) {
			throw new ClienteException();
		} 
		
		List<Cliente> clientes = this.banco.getListaCliente();
		
		if (clientes != null) {
			this.sacar(valor);
			this.banco.getContas().get(clientes.indexOf(cliente)).depositar(valor);
		} else {
			throw new ClienteException();
		}
	}
	
	@Override
	public Cliente encontrarCliente(Cliente cliente) {
		return (Cliente)banco.getListaCliente().stream().filter(c -> c == cliente).toArray()[0];
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
