package zoo.comando.comida;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Comida;
import zoo.comando.Comando;
import zoo.dao.ComidaDAO;

public class AlterarComida implements Comando {// implements comando herda class Comando, obrigando a 
											// ter o metodo execute
	public void execute(Scanner entrada) throws IOException {
		ComidaDAO com = new ComidaDAO();
		System.out.println("\nAlterar Comida...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();

		if (com.getComidaId(id) == null) {
			System.out.println("Nenhuma comida com esse Id cadastrada");
		}
		else {
			System.out.println("\nNome: ");
			String nome = entrada.next();
	
			Comida comida = new Comida(id, nome);
			com.alterar(comida);// update na tabela alimento do banco
		}
	}
}
