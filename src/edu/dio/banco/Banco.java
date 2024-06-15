package edu.dio.banco;

import java.util.ArrayList;
import java.util.List;

import edu.dio.banco.exceptions.*;

public class Banco {
	private String nome;
	private List<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	public List<Conta> getContas() {
		return contas;
	}
	
	public List<Cliente> getListaCliente(){
		List<Cliente> listaClientes = new ArrayList<>();
		this.contas.forEach(c -> listaClientes.add(c.getCliente()));
		return listaClientes;
	}
	
	public void adicionarConta(Conta conta) throws ContaException, ClienteException{
		if(conta == null)
			throw new ContaException();
		if(conta.getCliente() == null)
			throw new ClienteException();
		this.contas.add(conta);
	}
	
	public void exibirContas() {
		System.out.println("========Exibindo Contas=========");
		this.contas.stream().forEach(c -> c.imprimirExtrato());
	}
}
