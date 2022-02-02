package br.com.sistemabancario.usuario;

public class Caixa extends Funcionario {

	// CONSTRUTOR DEFAULT
	public Caixa() {

	}

	public Caixa(String senha, int cpf, String nome, String sobrenome, int tipo, boolean block,
			String cargo, double salario) {
		
		setSenha(senha);
		setCpf(cpf);
		setNome(nome);
		setSobreNome(sobrenome);
		setTipo(tipo);
		setBlock(block);
		setCargo(cargo);
		setSalario(salario);
	}

	@Override
	public String toString() {
		return "Caixa [cargo=" + cargo + ", salario=" + salario + ", senha=" + senha + ", cpf=" + cpf + ", nome=" + nome
				+ ", sobreNome=" + sobreNome + ", tipo=" + tipo + ", block=" + block + "]";
	}
}
