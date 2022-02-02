package br.com.sistemabancario.usuario;

public class Diretor extends Funcionario {
	// ATRIBUTOS
	private int agencia1, agencia2;

	// CONSTRUTOR DEFAULT
	public Diretor() {

	}

	// CONSTRUTOr
	public Diretor(String senha, int cpf, String nome, String sobrenome, int tipo, boolean block, String cargo,
			double salario, int agencia1, int agencia2) {
		
		setSenha(senha);
		setCpf(cpf);
		setNome(nome);
		setSobreNome(sobrenome);
		setTipo(tipo);
		setBlock(block);
		setCargo(cargo);
		setSalario(salario);
		setAgencia1(agencia1);
		setAgencia2(agencia2);
		
	}

	@Override
	public String toString() {
		return "Diretor [agencia1=" + agencia1 + ", agencia2=" + agencia2 + ", cargo=" + cargo + ", salario=" + salario
				+ ", senha=" + senha + ", cpf=" + cpf + ", nome=" + nome + ", sobreNome=" + sobreNome + ", tipo=" + tipo
				+ ", block=" + block + "]";
	}

	// GETTERS E SETTERS
	public boolean bloquearGerente() {
		return false;

	}

	public int getAgencia1() {
		return agencia1;
	}

	public void setAgencia1(int agencia1) {
		this.agencia1 = agencia1;
	}

	public int getAgencia2() {
		return agencia2;
	}

	public void setAgencia2(int agencia2) {
		this.agencia2 = agencia2;
	}

}
