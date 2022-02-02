package br.com.residencia.tributo;

import java.util.Scanner;
import br.com.sistemabancario.contas.Conta;
import br.com.sistemabancario.contas.ContaCorrente;
import br.com.sistemabancario.contas.MapaConta;
import br.com.sistemabancario.menu.Menus;
import br.com.sistemabancario.usuario.MapaDeUsuarios;
import br.com.sistemabancario.usuario.Usuario;

public class SeguroDeVida  {

	public void seguroDeVida() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja contratar o seguro de vida? ");
		System.out.println("1 = Sim\n2 = Não");
		int resp = sc.nextInt();

		if (resp == 1) {
			System.out.println("Qual é o valor que você deseja assegurar? ");
			double valorSeguro = sc.nextDouble();

			if (Conta.getSaldo() >= valorSeguro) {
				System.out.printf("Taxa valor seguro: R$ %.2f%n", valorSeguro * 0.2);

			} else {
				System.out.println("Saldo insuficiente");
			}
		}
	}
}