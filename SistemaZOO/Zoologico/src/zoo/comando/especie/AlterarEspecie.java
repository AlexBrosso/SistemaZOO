package zoo.comando.especie;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Especie;
import zoo.comando.Comando;
import zoo.dao.EspecieDAO;

public class AlterarEspecie implements Comando {
	public void execute(Scanner entrada) throws IOException {
		EspecieDAO esp = new EspecieDAO();
		System.out.println("\nAlterar Especie...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();
		
		if (esp.getEspecieId(id) == null) {
			System.out.println("Nenhuma especie com esse Id cadastrada");
		}
		else {
			System.out.println("\nNome: ");
			String nome = entrada.next();
	
			Especie especie = new Especie(id, nome);
			esp.alterar(especie);// update tabela especie banco
		}
	}
}
