package br.com.sistemabancario.contas;

import java.io.IOException;
import java.util.Map;

public abstract class Conta {
	
	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo
				+ ", cpfTitular=" + cpfTitular + "]";
	}

	protected int agencia;
	protected int numero;
	protected int tipo;
	protected static double saldo;
	protected int cpfTitular;
	
	//Métodos sacar
	
	public void sacar()  { 
		
	}
	
	//Método depositar
	
	public void depositar() {
		
		
	}

	//Método transferir
	
	public void transferir() {
	
	}
	
	// CONSTRUTOR DEFAULT
	public Conta() {

	}
	
	// CONSTRUTOR
	


	

	// GETTERS E SETTERS
	public int getAgencia() {
		return agencia;
	}
	//cpfCliente;agencia;numero;saldo;tipo;chequeEspecial;
	public Conta(int cpfTitular,int agencia, int numero, double saldo,int tipo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = saldo;
		this.cpfTitular = cpfTitular;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public static double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(int cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public boolean contratarSeguro() {
		return false;
	}

	
}
