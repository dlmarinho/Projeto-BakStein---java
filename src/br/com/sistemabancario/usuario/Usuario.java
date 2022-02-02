package br.com.sistemabancario.usuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Usuario {

	

	// ATRIBUTOS
	protected String senha;
	protected int cpf;
	protected String nome;
	protected String sobreNome;
	protected int tipo;
	protected boolean block;

	// CONSTRUTOR DEFAULT
	public Usuario() {

	}

	// CONSTRUTORES
	public Usuario(String senha, int cpf, String nome, String sobreNome, int tipo, boolean block) {
		super();
		this.senha = senha;
		this.cpf = cpf;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.tipo = tipo;
		this.block = block;
	}

	public static Map<Integer, Usuario> lerUsuario(Map<Integer, Usuario> maptipoUsuario)
			throws FileNotFoundException, IOException {

		String linha;
		
		final String PATH_BASICO = "./arquivos-bd/";

		try (BufferedReader csvReader = new BufferedReader(new FileReader(PATH_BASICO + "usuario.txt"))) {
			linha = csvReader.readLine();

			Map<Integer, Usuario> mapUsuario = new HashMap<>();

			while ((linha = csvReader.readLine()) != null) {

				

				String[] data = linha.split(";");

				String senha = data[0];
				int cpf = Integer.parseInt(data[1]);
				String nome = data[2];
				String sobrenome = data[3];
				boolean block = Boolean.parseBoolean(data[4]);
				int idFuncionario = Integer.parseInt(data[5]);
				Double salario = Double.parseDouble(data[6]);
				String cargo = data[7];
				int agencia1 = Integer.parseInt(data[8]);
				int agencia2 = Integer.parseInt(data[9]);

				if (idFuncionario == 1) {
					Usuario novoPresidente = new Presidente(senha, cpf, nome, sobrenome, idFuncionario, block, cargo,
							salario);
					mapUsuario.put(cpf, novoPresidente);
					//System.out.println(novoPresidente.toString());
				} else if (idFuncionario == 2) {
					Usuario novoDiretor = new Diretor(senha, cpf, nome, sobrenome, idFuncionario, block, cargo, salario,
							agencia1, agencia2);
					mapUsuario.put(cpf, novoDiretor);
					//System.out.println(novoDiretor.toString());
				} else if (idFuncionario == 3) {
					Usuario novoGerente = new Gerente(senha, cpf, nome, sobrenome, idFuncionario, block, cargo, salario,
							agencia1);
					mapUsuario.put(cpf, novoGerente);
					//System.out.println(novoGerente.toString());
				} else if (idFuncionario == 4) {
					Usuario novoCaixa = new Caixa(senha, cpf, nome, sobrenome, idFuncionario, block, cargo, salario);
					mapUsuario.put(cpf, novoCaixa);
					//System.out.println(novoCaixa.toString());
				} else if (idFuncionario == 5) {
					
					Usuario novoCliente = new Cliente(senha, cpf, nome, sobrenome, idFuncionario, block);
					mapUsuario.put(cpf, novoCliente);
					//System.out.println(novoCliente.toString());
				}
			}
			return mapUsuario;
		}
	}

	// GETTERS E SETTERS
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

}
