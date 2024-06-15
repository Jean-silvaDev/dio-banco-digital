package edu.dio.banco.contas;

import edu.dio.banco.Banco;
import edu.dio.banco.Cliente;
import edu.dio.banco.Conta;

public class ContaCorrente extends Conta {

	public ContaCorrente(int agencia, int numero, double saldo, Cliente cliente, Banco banco) {
		super(agencia, numero, saldo, cliente, banco);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
