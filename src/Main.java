import java.math.BigInteger;

import edu.dio.banco.Banco;
import edu.dio.banco.Cliente;
import edu.dio.banco.contas.*;
import edu.dio.banco.Conta;

public class Main {

	public static void main(String[] args) {
		try {
			Banco banco = new Banco("Banco");
			banco.adicionarConta(new ContaCorrente(1, 1, 10.0, new Cliente(BigInteger.valueOf(1123123L), "Cliente 1"), banco));
			banco.adicionarConta(new ContaPoupanca(1, 2, 0.0, new Cliente(BigInteger.valueOf(1121213123L), "Cliente 2"), banco));
			banco.adicionarConta(new ContaCorrente(2, 1, 150.0, new Cliente(BigInteger.valueOf(1112323123L), "Cliente 3"), banco));
		
			Cliente cliente = new Cliente(BigInteger.valueOf(1111111L), "Cliente");
			Conta conta = new ContaPoupanca(1, 3, 0, cliente, banco);
			Cliente cliente2 = new Cliente(BigInteger.valueOf(2222222L), "Cliente 2.0");
			Conta conta2 = new ContaCorrente(1, 4, 0, cliente2, banco);
			

			banco.adicionarConta(conta);
			banco.adicionarConta(conta2);

			conta.depositar(250);
			conta.transferir(100, cliente2);
			
			banco.exibirContas();

		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
