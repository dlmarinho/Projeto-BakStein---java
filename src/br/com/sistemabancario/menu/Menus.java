package br.com.sistemabancario.menu;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import br.com.sistemabancario.contas.Conta;
import br.com.sistemabancario.contas.ContaCorrente;
import br.com.sistemabancario.usuario.Cliente;
import br.com.sistemabancario.usuario.Gerente;
import br.com.sistemabancario.usuario.Usuario;
import br.com.residencia.tributo.SeguroDeVida;
import br.com.sistemabancario.IO.LeituraEscrita;

public abstract class Menus {

	boolean off = false;
	static Scanner sc = new Scanner(System.in);

	public static void login(Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {

		bankStein();

		System.out.println(" ---- LOGIN ----\n");
		System.out.println(" Insira seu cpf: \n(somente números)");
		int login = Integer.parseInt(sc.next());
		boolean clienteCadastrado = mapUsuario.containsKey(login);

		if (clienteCadastrado) {
			Usuario usuario = mapUsuario.get(login);

			System.out.println("Insira sua senha: ");
			String senha = sc.next();
			if (senha.equals(usuario.getSenha())) {

				menuOperacoes(login, maptipoUsuario, mapUsuario, mapConta);
			} else {
				System.out.println("****** Senha invalida! ******");
				System.out.println("\n|--------------------------------|\n\n");
				login(maptipoUsuario, mapUsuario, mapConta);
			}
		} else {
			System.out.println("****** Usuário não cadastrado! ******");
			System.out.println("\n|--------------------------------|\n\n");
			login(maptipoUsuario, mapUsuario, mapConta);
		}

	}

	public static void bankStein() {
		System.out.println(" /$$$$$$$                      /$$        /$$$$$$   /$$               /$$");
		System.out.println("| $$__  $$                    | $$       /$$__  $$ | $$              |__/");
		System.out.println("| $$    $$  /$$$$$$  /$$$$$$$ | $$   /$$| $$   __  $$$$$$    /$$$$$$  /$$ /$$$$$$$");
		System.out.println("| $$$$$$$  |____  $$| $$__  $$| $$  /$$/|  $$$$$$|_  $$_/   /$$__  $$| $$| $$__  $$");
		System.out.println("| $$__  $$  /$$$$$$$| $$    $$| $$$$$$/   ____  $$ | $$    | $$$$$$$$| $$| $$    $$");
		System.out.println("| $$    $$  /$$__ $$| $$  | $$| $$_  $$  /$$    $$ | $$ /$$| $$_____/| $$| $$  | $$");
		System.out.println("| $$$$$$$/|  $$$$$$$| $$  | $$| $$    $$|  $$$$$$/ |  $$$$/|  $$$$$$$| $$| $$  | $$");
		System.out.println("|_______/   _______/|__/  |__/|__/   __/  ______/    ___     _______/|__/|__/  |__/");
		System.out.println(" \n\n\n");
	}

	public static void menuOperacoes(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {

		Usuario usuario = mapUsuario.get(login);
		switch (usuario.getTipo()) {

		case 1:
			menuPresidente(login, maptipoUsuario, mapUsuario, mapConta);
			break;
		case 2:
			menuDiretor(login, maptipoUsuario, mapUsuario, mapConta);
			break;
		case 3:
			menuGerente(login, maptipoUsuario, mapUsuario, mapConta);
			break;
		case 4:
			menuCaixa(login, maptipoUsuario, mapUsuario, mapConta);
			break;
		case 5:
			menuCliente(login, maptipoUsuario, mapUsuario, mapConta);
			break;
		}
	}

	public static void menuPresidente(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {
		boolean off = false;
		do {
			System.out.println("");
			System.out.println("\n\n---- OPERAÇÕES BANCARIAS ----");
			System.out.println("\nSelecione a operação que deseja realizar:\n" + "1:\t Saque\n" + "2:\t Depositar\n"
					+ "3:\t Transferir\n" + "4:\t Consultar saldo\n" + "5:\t Consultar extrato\n"
					+ "6:\t Relatorio total capital" + "\n0:\t Sair");

			int resp = sc.nextInt();
			LeituraEscrita leitor = new LeituraEscrita();

			if (resp == 0) {
				off = true;
			} else {

				switch (resp) {
				case 1:
					menuSaqueF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 2:
					menuDepositoF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 3:
					menuTransferirF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 4:
					consultarSaldoF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 5:
					leitor.consultarExtratoF(login, mapConta);
					break;
				case 6:
					leitor.relatorioTotalCapital(login, mapConta);

					break;

				case 0:
					off = true;
					System.out.println("Volte sempre!");
					break;
				default:
					System.out.println("\nOPÇÃO INVÁLIDA!");
					System.out.println("\nDigite uma opção valida!");
					break;
				}
			}
		} while (!off);
	}

	public static void menuDiretor(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {
		boolean off = false;
		do {
			System.out.println("");
			System.out.println("\n\n---- OPERAÇÕES BANCARIAS ----");
			System.out.println("\nSelecione a operação que deseja realizar:\n" + "1:\t Saque\n" + "2:\t Depositar\n"
					+ "3:\t Transferir\n" + "4:\t Consultar saldo\n" + "5:\t Consultar extrato\n"
					+ "6:\t Relatorio total de clientes" + "\n0:\t Sair");

			int resp = sc.nextInt();
			LeituraEscrita leitor = new LeituraEscrita();
			if (resp == 0) {
				off = true;
			} else {

				switch (resp) {
				case 1:
					menuSaqueF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 2:
					menuDepositoF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 3:
					menuTransferirF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 4:
					consultarSaldoF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 5:
					leitor.consultarExtratoF(login, mapConta);
					break;
				case 6:
					leitor.relatorioTotalClientes(login, mapConta, mapUsuario);
					break;

				case 0:
					off = true;
					System.out.println("Volte sempre!");
					break;
				default:
					System.out.println("\nOPÇÃO INVÁLIDA!");
					System.out.println("\nDigite uma opção valida!");
					break;
				}
			}
		} while (!off);
	}

	public static void menuGerente(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {
		boolean off = false;
		do {
			System.out.println("");
			System.out.println("\n\n---- OPERAÇÕES BANCARIAS ----");
			System.out.println("\nSelecione a operação que deseja realizar:\n" + "1:\t Saque\n" + "2:\t Depositar\n"
					+ "3:\t Transferir\n" + "4:\t Consultar saldo\n" + "5:\t Consultar extrato\n"
					+ "6:\t Relatorio Gerente\n" + "7:\t Relatorio Tributação de Conta Corrente\n"
					+ "8:\t Relatorio rendimento de Poupança\n" + "\n0:\t Sair");
			LeituraEscrita leitor = new LeituraEscrita();
			int resp = sc.nextInt();

			if (resp == 0) {
				off = true;
			} else {

				switch (resp) {
				case 1:
					menuSaqueF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 2:
					menuDepositoF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 3:
					menuTransferirF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 4:
					consultarSaldoF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 5:
					leitor.consultarExtratoF(login, mapConta);
					break;
				case 6:
					relatorioGerente(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 7:
					leitor.relatorioTributacaoContaCorrente(login, resp, mapConta);
					break;
				case 8:
					leitor.relatorioRendimentoPoupanca(login, login, mapConta, resp);
					break;

				case 0:
					off = true;
					System.out.println("Volte sempre!");
					break;
				default:
					System.out.println("\nOPÇÃO INVÁLIDA!");
					System.out.println("\nDigite uma opção valida!");
					break;
				}
			}
		} while (!off);
	}

	public static void menuCliente(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {
		boolean off = false;
		do {
			System.out.println("");
			System.out.println("---- OPERAÇÕES BANCARIAS ----");
			System.out.println("\n\nSelecione a operação que deseja realizar:\n" + "1:\t Saque\n" + "2:\t Depositar\n"
					+ "3:\t Transferir\n" + "4:\t Consultar saldo\n" + "5:\t Consultar extrato\n" + "6:\t Seguro de vida\n"+"0:\t Sair");
			LeituraEscrita leitor = new LeituraEscrita();
			SeguroDeVida seguro = new SeguroDeVida();
			int resp = sc.nextInt();
			if (resp == 0) {
				off = true;
			} else {

				switch (resp) {
				case 1:
					menuSaque(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 2:
					menuDeposito(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 3:
					menuTransferir(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 4:
					consultarSaldo(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 5:
					leitor.consultarExtrato(login, mapConta);
					break;
				case 6: 
					seguro.seguroDeVida();
					break;
				case 0:
					off = true;
					System.out.println("Volte sempre!");
					break;
				default:
					System.out.println("\nOPÇÃO INVÁLIDA!");
					System.out.println("\nDigite uma opção valida!");
					break;
				}
			}
		} while (!off);
	}

	public static void menuCaixa(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {
		boolean off = false;
		do {
			System.out.println("");
			System.out.println("\n\n---- OPERAÇÕES BANCARIAS ----");
			System.out.println("\nSelecione a operação que deseja realizar:\n" + "1:\t Saque\n" + "2:\t Depositar\n"
					+ "3:\t Transferir\n" + "4:\t Consultar saldo\n" + "5:\t Consultar extrato\n" + "0:\t Sair");
			LeituraEscrita leitor = new LeituraEscrita();
			int resp = sc.nextInt();

			if (resp == 0) {
				off = true;
			} else {

				switch (resp) {
				case 1:
					menuSaqueF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 2:
					menuDepositoF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 3:
					menuTransferirF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 4:
					consultarSaldoF(login, maptipoUsuario, mapUsuario, mapConta);
					break;
				case 5:
					leitor.consultarExtrato(login, mapConta);
					break;
				case 0:
					off = true;
					System.out.println("Volte sempre!");
					break;
				default:
					System.out.println("\nOPÇÃO INVÁLIDA!");
					System.out.println("\nDigite uma opção valida!");
					break;
				}
			}
		} while (!off);
	}

	public static void menuSaqueF(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {

		int operador = login;

		double valor = 0;
		System.out.println("\n\n---- OPERAÇÃO SAQUE ----\n");
		System.out.println("\nColoque o CPF do titular da conta: \n(somente números)");
		int resp = sc.nextInt();

		ContaCorrente conta = (ContaCorrente) mapConta.get(resp);
		boolean clienteCadastrado = mapUsuario.containsKey(resp);

		if (clienteCadastrado) {
			System.out.println("\n\nInsira o valor a ser sacado");
			valor = sc.nextDouble();
			if (valor > 0) {
				conta.sacar(operador, resp, valor, maptipoUsuario, mapUsuario, mapConta);
			} else {
				System.out.println("****** Valor do saque incorreto! ******");
				System.out.println("\n|--------------------------------|\n\n");
			}
		} else {
			System.out.println("****** Dados incorretos! ******");
			System.out.println("\n|--------------------------------|\n\n");

			menuSaqueF(login, maptipoUsuario, mapUsuario, mapConta);
		}
	}

	public static void menuSaque(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {

		int operador = login;

		Usuario usuario = mapUsuario.get(login);
		ContaCorrente conta = (ContaCorrente) mapConta.get(login);
		double valor = 0;
		System.out.println("\n\n---- SAQUE ----\n");
		System.out.println("\nInsira o valor a ser sacado");
		valor = sc.nextDouble();

		if (valor > 0) {
			conta.sacar(operador, login, valor, maptipoUsuario, mapUsuario, mapConta);
		} else {
			System.out.println("****** Valor do saque incorreto! ******\n");
			System.out.println("\n|--------------------------------|\n\n");
		}

		menuSaque(login, maptipoUsuario, mapUsuario, mapConta);
	}

	public static void menuDepositoF(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {

		int operador = login;

		double valor = 0;
		System.out.println("\n\n---- OPERAÇÃO DEPOSITO ----\n");
		System.out.println("\nColoque o CPF do titular da conta: \n(somente números)");
		int resp = sc.nextInt();

		ContaCorrente conta = (ContaCorrente) mapConta.get(resp);

		boolean clienteCadastrado = mapUsuario.containsKey(resp);

		if (clienteCadastrado) {

			System.out.println("\n\nInsira o valor a ser depositado");
			valor = sc.nextDouble();
			if (valor > 0) {

				conta.depositar(operador, resp, valor, maptipoUsuario, mapUsuario, mapConta);

			} else {
				System.out.println("****** Dados incorretos! ******\n");
				System.out.println("\n|--------------------------------|\n\n");

				menuDepositoF(login, maptipoUsuario, mapUsuario, mapConta);
			}
		}
	}

	public static void menuDeposito(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {

		int operador = login;

		double valor = 0;
		ContaCorrente conta = (ContaCorrente) mapConta.get(login);

		System.out.println("\n\n---- DEPOSITO ----\n");
		System.out.println("\nInsira o valor a ser depositado");
		valor = sc.nextDouble();
		if (valor > 0) {
			conta.depositar(operador, login, valor, maptipoUsuario, mapUsuario, mapConta);
		} else {
			System.out.println("****** Dados incorretos! ******\n");
			System.out.println("\n|--------------------------------|\n\n");

			menuDeposito(login, maptipoUsuario, mapUsuario, mapConta);
		}
	}

	public static void menuTransferirF(int login, Map<Integer, Usuario> maptipoUsuario,
			Map<Integer, Usuario> mapUsuario, Map<Integer, Conta> mapConta) throws IOException, InterruptedException {

		int operador = login;

		double valor = 0;
		System.out.println("\n---- TRANSFERENCIA ----\n");
		System.out.println("\n\nColoque o CPF do titular da conta: \n(somente números)");
		int resp = sc.nextInt();

		ContaCorrente conta = (ContaCorrente) mapConta.get(resp);
		boolean clienteCadastrado = mapUsuario.containsKey(resp);

		if (clienteCadastrado) {
			System.out.println("\n\nColoque o CPF do titular da conta destino: \n(somente números)");
			int destinatario = sc.nextInt();

			System.out.println("\n\nInsira o valor: ");
			valor = sc.nextDouble();
			// int login, double valor, int cpfDestinatario, Map<Integer, Usuario>
			// maptipoUsuario,
			// Map<Integer, Usuario> mapUsuario, Map<Integer, Conta> mapConta
			conta.transferir(operador, resp, valor, destinatario, maptipoUsuario, mapUsuario, mapConta);
		} else {
			System.out.println("****** Usuário não cadastrado! ******");
			System.out.println("\n|--------------------------------|\n\n");

			menuTransferirF(login, maptipoUsuario, mapUsuario, mapConta);
		}
	}

	public static void menuTransferir(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws IOException, InterruptedException {

		int operador = login;

		double valor = 0;
		ContaCorrente conta = (ContaCorrente) mapConta.get(login);
		System.out.println("\n\n---- TRANSFERENCIA ----\n");
		System.out.println("\nColoque o CPF do titular da conta destino: \n(somente números)");
		int destinatario = sc.nextInt();

		System.out.println("\n\nInsira o valor: ");
		valor = sc.nextDouble();
		if (valor > 0) {
			conta.transferir(operador, login, valor, destinatario, maptipoUsuario, mapUsuario, mapConta);

		} else {
			System.out.println("****** Dados incorretos! ******\n");
			System.out.println("\n|--------------------------------|\n\n");

			menuTransferir(login, mapUsuario, mapUsuario, mapConta);
		}
	}

	public static void consultarSaldoF(int login, Map<Integer, Usuario> maptipoUsuario,
			Map<Integer, Usuario> mapUsuario, Map<Integer, Conta> mapConta) throws InterruptedException {

		double valor = 0;
		System.out.println("\n\n---- CONSULTA SALDO ----\n");
		System.out.println("\nColoque o CPF do titular da conta: \n(somente números)");
		int resp = sc.nextInt();

		ContaCorrente conta = (ContaCorrente) mapConta.get(resp);

		boolean clienteCadastrado = mapUsuario.containsKey(resp);

		if (clienteCadastrado) {

			System.out.printf("\n\nSeu saldo é de: R$ %.2f ", conta.getSaldo());
			System.out.println("\n\n BankStein agradece a preferencia!");
			Thread.sleep(2000);

		} else {
			System.out.println("****** Usuário não cadastrado! ******\n");
			System.out.println("\n|--------------------------------|\n\n");

			consultarSaldoF(login, maptipoUsuario, mapUsuario, mapConta);
		}
	}

	public static void consultarSaldo(int login, Map<Integer, Usuario> maptipoUsuario, Map<Integer, Usuario> mapUsuario,
			Map<Integer, Conta> mapConta) throws InterruptedException {
		Conta conta = mapConta.get(login);
		System.out.println("\n\n---- CONSULTA SALDO ----\n");
		System.out.printf("\nSeu saldo é de: R$ %.2f ", conta.getSaldo());
		System.out.println("\n\n BankStein agradece a preferencia!");
		Thread.sleep(2000);
	}

	public static void relatorioGerente(int login, Map<Integer, Usuario> maptipoUsuario,
			Map<Integer, Usuario> mapUsuario, Map<Integer, Conta> mapConta) {
		Usuario usuario = mapUsuario.get(login);
		Gerente gerente = (Gerente) mapUsuario.get(login);

		gerente.setAgencia1(login);

		for (Conta c : mapConta.values()) {
			while (c.getAgencia() == Gerente.getAgencia1()) {
				System.out.println(c.toString());

			}

//	public static void consultarExtrato(int login, Map<Integer, Usuario> maptipoUsuario,
//		Map<Integer, Usuario> mapUsuario, Map<Integer, Conta> mapConta) {
//		
//	}
		}
	}

}
