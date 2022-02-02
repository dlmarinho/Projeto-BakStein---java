
package br.com.sistemabancario.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import br.com.residencia.tributo.Tributo;
import br.com.sistemabancario.contas.Conta;
import br.com.sistemabancario.contas.ContaCorrente;
import br.com.sistemabancario.usuario.Diretor;
import br.com.sistemabancario.usuario.Usuario;

public class LeituraEscrita {
	static final String PATH_BASICO = "./arquivos-bd/";
	static final String EXTENSAO = ".txt";

	public static void escritor(String path) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo: ");
		String file = sc.next();

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO));

		String linha = "";

		System.out.println("Escreva algo: ");
		linha = sc.next();

		buffWrite.append(linha + "\n");
		buffWrite.close();
		sc.close();
	}

	public static void comprovanteSaque(int cpf, double valorSaque, Map<Integer, Conta> mapConta) throws IOException {
		ContaCorrente conta = (ContaCorrente) mapConta.get(cpf);
		String file = conta.getCpfTitular() + "_" + conta.getAgencia() + "_" + conta.getNumero() + "_transacoes";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		String linha = " - - - - - - - - - - - SAQUE - - - - - - - - - - - ";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumero();
		buffWrite.append(linha + "\n");

		linha = "Valor: R$" + valorSaque;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "- - - - - - - - - - - - - - - - - - - - - - - ";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void comprovanteDeposito(int cpf, double valorDeposito, Map<Integer, Conta> mapConta)
			throws IOException {
		ContaCorrente conta = (ContaCorrente) mapConta.get(cpf);

		String file = conta.getCpfTitular() + "_" + conta.getAgencia() + "_" + conta.getNumero() + "_transacoes";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		String linha = "- - - - - - - - - - -  DEPÓSITO - - - - - - - - - - - ";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumero();
		buffWrite.append(linha + "\n");

		linha = "Valor: R$" + valorDeposito;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "- - - - - - - - - - - - - - - - - - - - - - - ";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void debitoDoSeguro(int cpf, double valorSeguro, Map<Integer, Conta> mapConta) throws IOException {
		Conta conta = mapConta.get(cpf);
		String file = conta.getCpfTitular() + "_" + conta.getAgencia() + "_" + conta.getNumero() + "_tributacao";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		String linha = "- - - - - - - - - - -  SEGURO DE VIDA  - - - - - - - - - - -  ";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumero();
		buffWrite.append(linha + "\n");

		linha = "Valor do seguro: R$" + valorSeguro;
		buffWrite.append(linha + "\n");

		linha = "Debito na contratação do Seguro: R$" + valorSeguro * 0.2;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "- - - - - - - - - - - - - - - - - - - - - - - ";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void comprovanteTransferencia(int cpf, double valorTransferencia, Map<Integer, Conta> mapConta,
			int destinatario) throws IOException {
		Conta conta = mapConta.get(cpf);
		Conta destinarario = mapConta.get(cpf);

		String file = conta.getCpfTitular() + "_" + conta.getAgencia() + "_" + conta.getNumero() + "_transferencia";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		String linha = "- - - - - - - - - - -  TRANSFERÊNCIA REALIZADA  - - - - - - - - - - -  ";
		buffWrite.append(linha + "\n\n");

		linha = "- - - - - - - - - - -  DADOS DO REMETENTE  - - - - - - - - - - -  ";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência : " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumero();
		buffWrite.append(linha + "\n");

		linha = "- - - - - - - - - - -  DADOS DO DESTINATÁRIO - - - - - - - - - - -  ";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + destinarario.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + destinarario.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + destinarario.getNumero();
		buffWrite.append(linha + "\n");

		linha = "- - - - - - - - - - - - - - - - - - - - - - - ";
		buffWrite.append(linha + "\n");

		linha = "Valor: R$" + valorTransferencia;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "- - - - - - - - - - -  FIM DA TRANSFERÊNCIA  - - - - - - - - - - -  ";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

		// REGISTRAR DADOS NO COMPROVANTE DO DESTINATÁRIO

		file = destinarario.getCpfTitular() + "_" + destinarario.getAgencia() + "_" + destinarario.getNumero()
				+ "_transferencia";

		buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		linha = "- - - - - - - - - - -  TRANSFERÊNCIA RECEBIDA  - - - - - - - - - - -  ";
		buffWrite.append(linha + "\n\n");

		linha = "- - - - - - - - - - -   DADOS DO REMETENTE  - - - - - - - - - - -  ";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência : " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumero();
		buffWrite.append(linha + "\n");

		linha = "- - - - - - - - - - -   DADOS DO DESTINATÁRIO  - - - - - - - - - - -  ";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + destinarario.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + destinarario.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + destinarario.getNumero();
		buffWrite.append(linha + "\n");

		linha = "- - - - - - - - - - - - - - - - - - - - - - - ";
		buffWrite.append(linha + "\n");

		linha = "Valor: R$" + valorTransferencia;
		buffWrite.append(linha + "\n");

		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "*************** FIM DA TRANSFERÊNCIA ***************";
		buffWrite.append(linha + "\n");

		buffWrite.close();

	}

	public static void relatorioTributacaoContaCorrente(int cpf, double valorSeguro, Map<Integer, Conta> mapConta)
			throws IOException {
		ContaCorrente conta = (ContaCorrente) mapConta.get(cpf);
		String file = conta.getCpfTitular() + "_" + conta.getAgencia() + "_" + conta.getNumero() + "_tributacoes";
		System.out.println("Relatorio realizado com sucesso!");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		String linha = "*************** TOTAL DE TRIBUTAÇÕES ***************";
		buffWrite.append(linha + "\n\n");

		linha = "Total gasto com transações = R$" + ((ContaCorrente) conta).getTotalTributado();
		buffWrite.append(linha + "\n");

		linha = "Taxa para saque = R$" + Tributo.SAQUE;
		buffWrite.append(linha + "\n");

		linha = "Total de saques realizados = " + ((ContaCorrente) conta).getTotalSaques();
		buffWrite.append(linha + "\n\n");

		linha = "Taxa para deposito = R$" + Tributo.DEPOSITO;
		buffWrite.append(linha + "\n");

		linha = "Total de depósitos realizados = " + ((ContaCorrente) conta).getTotalDepositos();
		buffWrite.append(linha + "\n\n");

		linha = "Taxa para tranferência = R$" + Tributo.TRANSFERENCIA;
		buffWrite.append(linha + "\n");

		linha = "Total de transferências realizadas = " + ((ContaCorrente) conta).getTotalTransferencias();
		buffWrite.append(linha + "\n\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "****************************************************";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void relatorioRendimentoPoupanca(int login, double valorRendimento, Map<Integer, Conta> mapConta,
			int dias) throws IOException {
		Conta conta = mapConta.get(login);
		String file = conta.getCpfTitular() + "" + conta.getAgencia() + "" + conta.getNumero() + "_rendimento";
		System.out.println("Relatorio realizado com sucesso!");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		String linha = "* SIMULAÇÃO DE RENDIMENTO *";
		buffWrite.append(linha + "\n\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência : " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumero();
		buffWrite.append(linha + "\n");

		linha = "***";
		buffWrite.append(linha + "\n\n");

		linha = "Valor simulado = R$" + valorRendimento;
		buffWrite.append(linha + "\n");

		linha = "Dias de rendimento = " + dias;
		buffWrite.append(linha + "\n");

		linha = "Total estimado = R$" + (valorRendimento + ((valorRendimento * 0.1) * dias));
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "***";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void relatorioContasPorAgencia(int login, Map<Integer, Conta> mapConta) throws IOException {
		ContaCorrente conta = (ContaCorrente) mapConta.get(login);
		String file = conta.getCpfTitular() + "" + conta.getAgencia() + "" + conta.getNumero() + "_contas_por_agencia";
		System.out.println("Relatorio realizado com sucesso!");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		int totalContas = 0;

		String linha = "* INFORMAÇÕES DO RESPONSÁVEL *";
		buffWrite.append(linha + "\n\n");

		linha = "CPF: " + conta.getCpfTitular();
		buffWrite.append(linha + "\n");

		linha = "Agência : " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "***";
		buffWrite.append(linha + "\n\n");

		linha = "* TOTAL DE CONTAS NA MESMA AGÊNCIA *";
		buffWrite.append(linha + "\n\n");

		for (int cpf : mapConta.keySet()) {
			if (mapConta.get(cpf).getNumero() == (conta.getNumero())) {

				linha = "CPF: " + mapConta.get(cpf).getCpfTitular();
				buffWrite.append(linha + "\n");

				linha = "Agência : " + mapConta.get(cpf).getAgencia();
				buffWrite.append(linha + "\n");

				linha = "Conta: " + mapConta.get(cpf).getNumero();
				buffWrite.append(linha + "\n");

				totalContas++;

				linha = "**";
				buffWrite.append(linha + "\n");
			}

		}

		linha = "Total de contas: " + totalContas;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "****";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	
	public static void relatorioTotalClientes(int login, Map<Integer, Conta> mapConta, Map<Integer, Usuario> mapUsuario)
			throws IOException {
		Diretor diretor = (Diretor) mapUsuario.get(login);
		int agencia1 = diretor.getAgencia1();
		int agencia2 = diretor.getAgencia2();

		String file = diretor.getCargo() + "" + diretor.getCpf() + "" + diretor.getNome() + "_total_clientes";
		System.out.println("Relatorio realizado com sucesso!");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		String linha = "\n\n - - - - - - - - - -  TOTAL DE CLIENTES  - - - - - - - - - - \n\n";
		buffWrite.append(linha + "\n\n");

		for (Conta c : mapConta.values()) {
			ContaCorrente conta = (ContaCorrente) mapConta.get(c);
			if (conta.getAgencia() == agencia1 || conta.getAgencia() == agencia2) {
				int cpf = conta.getCpfTitular();
				for (int x : mapUsuario.keySet()) {
					if (x == cpf) {
						linha = mapUsuario.get(x).toString();
						buffWrite.append(linha + "\n\n");
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = " - - - - - - - - - - - - - - - - - - - - ";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void relatorioTotalCapital(int login, Map<Integer, Conta> mapConta) throws IOException {
		Conta conta = mapConta.get(login);
		String file = conta.getCpfTitular() + "" + conta.getAgencia() + "" + conta.getNumero() + "_total_capital";
		System.out.println("Relatorio realizado com sucesso!");
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		double saldoTotal = 0.0;

		String linha = "* TOTAL DE CAPITAL ARMAZENADO *";
		buffWrite.append(linha + "\n\n");

		for (int cpf : mapConta.keySet()) {

			saldoTotal += mapConta.get(cpf).getSaldo();

		}

		linha = "O total de capital armazenado no banco é de: R$" + saldoTotal;
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "***";
		buffWrite.append(linha + "\n\n");

		buffWrite.close();

	}

	public static void comprovanteSaldo(int cpf, Map<Integer, Conta> mapConta) throws IOException {
		Conta conta = mapConta.get(cpf);
		String file = conta.getCpfTitular() + "" + conta.getAgencia() + "" + conta.getNumero() + "_comprovanteSaldo";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + file + EXTENSAO, true));

		String linha = "* SALDO *";
		buffWrite.append(linha + "\n");

		linha = "Tipo: " + conta.getTipo();
		buffWrite.append(linha + "\n");

		linha = "Agência: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "Conta: " + conta.getNumero();
		buffWrite.append(linha + "\n");

		linha = "Saldo: R$" + conta.getSaldo();
		buffWrite.append(linha + "\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		linha = "Operação realizada em: " + simpleDateFormat.format(date);
		buffWrite.append(linha + "\n");

		linha = "* FIM *";
		buffWrite.append(linha + "\n");

		buffWrite.close();

	}

	public void consultarExtrato(int login, Map<Integer, Conta> mapConta) throws IOException {
		ContaCorrente conta = (ContaCorrente) mapConta.get(login);
		String file = conta.getCpfTitular() + "_" + conta.getAgencia() + "_" + conta.getNumero() + "_transacoes.txt";

		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + file));
			String linha = "";

			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					System.out.println(linha);
				} else
					break;
			}
			buffRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no local especificado: " + PATH_BASICO + file + " " + e);
		}
	}

	public void consultarExtratoF(int login, Map<Integer, Conta> mapConta) throws IOException {

		System.out.println("\nColoque o CPF do titular da conta: \n(somente números)");

		Scanner sc = new Scanner(System.in);
		int resp = sc.nextInt();

		ContaCorrente conta = (ContaCorrente) mapConta.get(resp);
		String file = conta.getCpfTitular() + "_" + conta.getAgencia() + "_" + conta.getNumero() + "_transacoes.txt";

		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + file));
			String linha = "";

			while (true) {
				linha = buffRead.readLine();
				if (linha != null) {
					System.out.println(linha);
				} else
					break;
			}
			buffRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado no local especificado: " + PATH_BASICO + file + " " + e);
		}

	}
}
