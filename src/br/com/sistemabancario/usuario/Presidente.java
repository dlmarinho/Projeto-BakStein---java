package br.com.sistemabancario.usuario;

public class Presidente extends Funcionario {
	// ATRIBUTOS

	public boolean bloquearDiretor(Diretor diretor) {
		diretor.setBlock(true);
		return true;
	}

	// CONSTRUTORERS
	// Default
	public Presidente() {

	}

	// Contrautor Geral
	public Presidente(String senha, int cpf, String nome, String sobrenome, int tipo, boolean block, String cargo,
			double salario) {
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
		return "Presidente [cargo=" + cargo + ", salario=" + salario + ", senha=" + senha + ", cpf=" + cpf + ", nome="
				+ nome + ", sobreNome=" + sobreNome + ", tipo=" + tipo + ", block=" + block + "]";
	}

	

}
