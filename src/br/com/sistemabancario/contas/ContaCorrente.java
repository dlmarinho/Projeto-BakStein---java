package br.com.sistemabancario.contas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import br.com.residencia.tributo.Tributo;
import br.com.sistemabancario.IO.LeituraEscrita;
import br.com.sistemabancario.menu.Menus;
import br.com.sistemabancario.usuario.Usuario;

public class ContaCorrente extends Conta {

	private Integer totalSaques = 0, totalDepositos = 0, totalTransferencias = 0;
	private Double totalTributado = 0.0;

	public Integer getTotalSaques() {
		return totalSaques;
	}

	public Integer getTotalDepositos() {
		return totalDepositos;
	}

	public Integer getTotalTransferencias() {
		return totalTransferencias;
	}

	public Double getTotalTributado() {
		return totalTributado;
	}

	@Override
	public String toString() {
		return "ContaCorrente [TAXASAQUE=" + Tributo.SAQUE + ", TAXADEPOSITO=" + Tributo.DEPOSITO
				+ ", TAXATRANSFERENCIA=" + Tributo.TRANSFERENCIA + ", chequeEspecial=" + chequeEspecial + ", agencia="
				+ agencia + ", numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + ", cpfTitular=" + cpfTitular
				+ "]";
	}

	// ATRIBUTOS

	protected double chequeEspecial;
	// CONSTRUTOR DEFAULT

	// cpfCliente;agencia;numero;saldo;tipo
	public ContaCorrente(int cpfTitular, int agencia, int numero, double saldo, int tipo, double chequeEspecial) {
		super(agencia, numero, tipo, saldo, cpfTitular);
		this.chequeEspecial = chequeEspecial;
	}

	public ContaCorrente() {

		// TODO Auto-generated constructor stub
	}

	public boolean sacar(int operador, int login, double valor, Map<Integer, Usuario> maptipoUsuario,
			Map<Integer, Usuario> mapUsuario, Map<Integer, Conta> mapConta) throws IOException, InterruptedException {
		if (this.saldo < valor) {
			System.out.println("\nSaldo insuficiente!!");
			return false;
		} else {
			this.saldo = this.saldo - valor - Tributo.SAQUE;
			System.out.println("\nSaque realizada com sucesso!!");
			System.out.printf("Valor sacado: R$%.2f%n", valor, "\n");
			System.out.printf("\nA taxa de saque é de: R$ %.2f", Tributo.SAQUE);
			System.out.printf("\nSeu saldo Atual é de: R$ %.2f", getSaldo());
			// banco.depositar(TAXASAQUE);
			System.out.println("\n\nDeseja imprimir um comprovante ? \n1\tSIM\n2\tNÃO");
			Scanner sc = new Scanner(System.in);
			int resp = sc.nextInt();
			if (resp == 1) {
				LeituraEscrita comprovante = new LeituraEscrita();
//	Cannot invoke "br.com.sistemabancario.contas.Conta.getCpfTitular()" because "conta" is null
				comprovante.comprovanteSaque(login, valor, mapConta);
				carregando();

				limpaTela();
				serratec();
				Menus.menuOperacoes(operador, maptipoUsuario, mapUsuario, mapConta);
			} else {
				Menus.menuOperacoes(operador, maptipoUsuario, mapUsuario, mapConta);
			}
			sc.close();
			return true;
		}

		// banco + taxasaque;
		// banco.getSaldo;
	}

	// Método depositar
	public void depositar(int operador, int login, double valor, Map<Integer, Usuario> maptipoUsuario,
			Map<Integer, Usuario> mapUsuario, Map<Integer, Conta> mapConta) throws IOException, InterruptedException {
		
		this.saldo += valor - Tributo.DEPOSITO;
		System.out.println("\nDeposito realizada com sucesso");
		System.out.printf("\nValor depositado: R$%.2f%n", valor, "\n");
		System.out.printf("\nA taxa de deposito é de: R$ %.2f", Tributo.DEPOSITO);
		System.out.printf("\nSeu saldo Atual é de: R$ %.2f", getSaldo());
		// int cpf, double valorDeposito, Map<Integer, Conta> mapConta

		System.out.println("\n\nDeseja imprimir um comprovante ? \n1\tSIM\n2\tNÃO");
		Scanner sc = new Scanner(System.in);
		int resp = sc.nextInt();
		if (resp == 1) {
			LeituraEscrita comprovante = new LeituraEscrita();

			comprovante.comprovanteDeposito(login, valor, mapConta);
			carregando();

			limpaTela();
			serratec();
			Menus.menuOperacoes(operador, maptipoUsuario, mapUsuario, mapConta);
		} else {
			Menus.menuOperacoes(operador, maptipoUsuario, mapUsuario, mapConta);
		}

	}

	// Método transferir
	public void transferir(int operador, int login, double valor, int cpfDestinatario, Map<Integer, Usuario> maptipoUsuario,
			Map<Integer, Usuario> mapUsuario, Map<Integer, Conta> mapConta) throws IOException, InterruptedException {
		
		ContaCorrente conta = (ContaCorrente) mapConta.get(login);
		Conta destinatario = mapConta.get(cpfDestinatario);
		
		if (valor <= this.saldo) {
			this.saldo = this.saldo - valor - Tributo.TRANSFERENCIA;
			destinatario.saldo += valor;
			System.out.println("\nTransferencia realizada com sucesso");
			System.out.printf("\nValor transferido: R$%.2f%n", valor, "\n");
			System.out.printf("\nA taxa de transferencia é de: R$ %.2f", Tributo.TRANSFERENCIA);
			System.out.printf("\nSeu novo saldo é de: R$ %.2f ", getSaldo());
			// banco.depositar(TAXASAQUE);
			System.out.println("\n\nDeseja imprimir um comprovante ? \n1\tSIM\n2\tNÃO");
			Scanner sc = new Scanner(System.in);
			int resp = sc.nextInt();
			if (resp == 1) {
				LeituraEscrita comprovante = new LeituraEscrita();
				carregando();
				comprovante.comprovanteTransferencia(login, valor, mapConta, cpfDestinatario);

				limpaTela();
				serratec();
				Menus.menuOperacoes(operador, maptipoUsuario, mapUsuario, mapConta);
			} else {
				Menus.menuOperacoes(operador, maptipoUsuario, mapUsuario, mapConta);
			}
		} else {
			System.out.println("\nSaldo insuficiente");

		}
	}

	public void carregando() throws InterruptedException {
		Thread.sleep(1000);
		System.out.print("carregando...");
		Thread.sleep(1000);
		System.out.print("..");
		Thread.sleep(1000);
		System.out.print("...");
		Thread.sleep(1000);
		System.out.print("....");
		Thread.sleep(1000);
		System.out.print("\n\nComprovante gerado com sucesso!");
		Thread.sleep(1000);
		System.out.print("\n\nBankStein Agradece a preferencia");
		Thread.sleep(3000);
	}

	public void limpaTela() {
		for (int i = 0; i < 50; i++) {
			System.out.println(" ");
		}
	}

	public void serratec() {

		System.out.print("\n\n");
		System.out.print(" ## ##   ### ###  ### ##   ### ##     ##     #### ##  ### ###   ## ## \n");
		System.out.print("##   ##   ##  ##   ##  ##   ##  ##     ##    # ## ##   ##  ##  ##   ## \n");
		System.out.print("####      ##       ##  ##   ##  ##   ## ##     ##      ##      ## \n");
		System.out.print(" #####    ## ##    ## ##    ## ##    ##  ##    ##      ## ##   ## \n");
		System.out.print("    ###   ##       ## ##    ## ##    ## ###    ##      ##      ## \n");
		System.out.print("##   ##   ##  ##   ##  ##   ##  ##   ##  ##    ##      ##  ##  ##   ## \n");
		System.out.print(" ## ##   ### ###  #### ##  #### ##  ###  ##   ####    ### ###   ## ## \n");

	}

	

	// GETTERS E SETTERS
	public double getTAXASAQUE() {
		return Tributo.SAQUE;
	}

	public double getTAXADEPOSITO() {
		return Tributo.DEPOSITO;
	}

	public double getTAXATRANSFERENCIA() {
		return Tributo.TRANSFERENCIA;
	}

}
