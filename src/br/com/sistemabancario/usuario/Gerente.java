package br.com.sistemabancario.usuario;

public class Gerente extends Funcionario {
	// ATRIBUTOS
	protected static int agencia1;

	// CONSTRUTOR DEFAULT
	public Gerente() {

	}
	//CONSTRUTOR
	public Gerente(String senha, int cpf, String nome, String sobrenome, int tipo, boolean block,
			String cargo, double salario, int agencia1) {
		setSenha(senha);
		setCpf(cpf);
		setNome(nome);
		setSobreNome(sobrenome);
		setTipo(tipo);
		setBlock(block);
		setCargo(cargo);
		setSalario(salario);
		setAgencia1(agencia1);
	}


	@Override
	public String toString() {
		return "Gerente [agencia1=" + agencia1 + ", cargo=" + cargo + ", salario=" + salario + ", senha=" + senha
				+ ", cpf=" + cpf + ", nome=" + nome + ", sobreNome=" + sobreNome + ", tipo=" + tipo + ", block=" + block
				+ "]";
	}
	public void criarConta() {

	}

	public boolean bloquearFuncionario() {
		return false;

	}
	public static int getAgencia1() {
		return agencia1;
	}
	public void setAgencia1(int agencia1) {
		this.agencia1 = agencia1;
	}
	

}
