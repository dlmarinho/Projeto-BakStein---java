package br.com.sistemabancario.contas;

public class ContaPoupanca extends ContaCorrente {

	@Override
	public String toString() {
		return "ContaPoupanca [TAXARENDIMENTO=" + TAXARENDIMENTO + ", chequeEspecial=" + chequeEspecial + ", agencia="
				+ agencia + ", numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + ", cpfTitular=" + cpfTitular
				+ "]";
	}

	// ATRIBUTOS
	private final double TAXARENDIMENTO = 0.01;

	// cpfCliente;agencia;numero;saldo;tipo
	// CONSTRUTOR
	public ContaPoupanca(int cpfTitular, int agencia, int numero, double saldo, int tipo, double chequeEspecial) {
		super(cpfTitular, agencia, numero, saldo, tipo,chequeEspecial);

	}

	// CONSTRUTOR DEFAULT
	public ContaPoupanca() {

	}

	// GETS E SETS
	public double getTAXARENDIMENTO() {
		return TAXARENDIMENTO;
	}
	
}
