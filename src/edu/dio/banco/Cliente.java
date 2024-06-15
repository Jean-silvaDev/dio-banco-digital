package edu.dio.banco;

import java.math.BigInteger;
import java.util.Objects;

public class Cliente {
	private BigInteger cpf;
	private String nome;
	
	public Cliente(BigInteger cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public BigInteger getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}
}
