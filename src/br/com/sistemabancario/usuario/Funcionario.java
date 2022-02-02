package br.com.sistemabancario.usuario;

public class Funcionario extends Usuario{
	//ATRIBUTOS
	protected String cargo;
	protected double salario;
	
	//CONSTRUTOR
	public Funcionario(String cargo, double salario) {
		super();
		this.cargo = cargo;
		this.salario = salario;
		
	}
	//CONSTRUTOR DEFAULT
	public Funcionario() {
		
	}
	
	//GETTERS E SETTERS
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	
}
