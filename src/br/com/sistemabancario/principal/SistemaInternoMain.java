package br.com.sistemabancario.principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import br.com.sistemabancario.contas.Conta;
import br.com.sistemabancario.contas.MapaConta;
import br.com.sistemabancario.menu.Menus;
import br.com.sistemabancario.usuario.MapaDeUsuarios;
import br.com.sistemabancario.usuario.Usuario;


public class SistemaInternoMain extends Menus{
	
	static Map<Integer, Usuario> maptipoUsuario;
	static Map<Integer, Usuario> mapUsuario;
	static Map<Integer, Conta> mapConta;
			
	public static void main(String[] args) throws IOException, InterruptedException {
	
	
		
	try {
		maptipoUsuario = MapaDeUsuarios.lertipoUsuario();
		mapUsuario = Usuario.lerUsuario(maptipoUsuario);
		mapConta = MapaConta.lerConta();
	} catch (FileNotFoundException e) {
		System.out.println("Arquivo não encontrado");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Não encontrada a saida ou a entrada do arquivo");
		e.printStackTrace();
	} catch (Exception e) {
		System.out.println("Erro maluco");
		e.printStackTrace();
	}
	
	Menus.login( maptipoUsuario,mapUsuario, mapConta);
	
	

	
	

	

	}

}
