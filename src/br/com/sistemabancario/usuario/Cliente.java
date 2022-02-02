package br.com.sistemabancario.usuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Usuario {


	// CONSTRUTORES

	public Cliente(String senha, int cpf, String nome, String sobreNome, int tipo, boolean block) {
		super(senha, cpf, nome, sobreNome, tipo, block);
	
	}

	// CONSTRUTOR DEFAULT
	public Cliente() {

	}

	@Override
	public String toString() {
		return "Cliente [senha=" + senha + ", cpf=" + cpf + ", nome=" + nome + ", sobreNome=" + sobreNome + ", tipo="
				+ tipo + ", block=" + block + "]";
	}

}
