package br.com.sistemabancario.usuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapaDeUsuarios extends Usuario {
	
	final static String EXTENSAO = ".txt";
	
	public MapaDeUsuarios(int tipoUsuarios) {
		this.tipo = tipoUsuarios;
	}
	
	public static Map<Integer, Usuario> lertipoUsuario() throws FileNotFoundException, IOException {
		
		final String PATH_BASICO = "./arquivos-bd/";

		Map<Integer, Usuario> maptipoUsuario = new HashMap<>();

		String linha1;

		try (BufferedReader csvReader1 = new BufferedReader(new FileReader(PATH_BASICO + "tipoUsuarios.txt"))) {
			linha1 = csvReader1.readLine();

			while ((linha1 = csvReader1.readLine()) != null) {


				String[] data = linha1.split(";"); 

				String tipoUsuarios = data[0];
				int idUsuario = Integer.parseInt(data[0]);

				Usuario novoUsuario = new MapaDeUsuarios(idUsuario);

				maptipoUsuario.put(idUsuario, novoUsuario);

			}
			return maptipoUsuario;
		}
		
	}
}
