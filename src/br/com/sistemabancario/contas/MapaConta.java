package br.com.sistemabancario.contas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapaConta extends Conta {

	public static Map<Integer, Conta> lerConta() throws IOException, FileNotFoundException {
		String linha;
		final String PATH_BASICO = "./arquivos-bd/";
		try (BufferedReader csvReader = new BufferedReader(new FileReader(PATH_BASICO + "criaConta.txt"))) {
			linha = csvReader.readLine();

			Map<Integer, Conta> mapConta = new HashMap<>();

			while ((linha = csvReader.readLine()) != null) {

				String[] data = linha.split(";");

				int cpfTitular = Integer.parseInt(data[0]);
				int agencia = Integer.parseInt(data[1]);
				int numero = Integer.parseInt(data[2]);
				double saldo = Double.parseDouble(data[3]);
				int tipo = Integer.parseInt(data[4]);
				double chequeEspecial = Double.parseDouble(data[5]);

				if (tipo == 1) {
					Conta novaConta = new ContaCorrente(cpfTitular, agencia, numero, saldo, tipo, chequeEspecial);
					mapConta.put(cpfTitular, novaConta);
					//System.out.println(novaConta.toString());
				} else {
					Conta novaContaP = new ContaPoupanca(cpfTitular, agencia, numero, saldo, tipo, chequeEspecial);
					mapConta.put(cpfTitular, novaContaP);
					//System.out.println(novaContaP.toString());
				}

			}
			return mapConta;
		}
	}
}
