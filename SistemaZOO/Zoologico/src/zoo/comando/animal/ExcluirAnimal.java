package zoo.comando.animal;

import java.io.IOException;
import java.util.Scanner;

import zoo.comando.Comando;
import zoo.dao.AnimalDAO;

public class ExcluirAnimal implements Comando {// implements comando herda class Comando, obrigando a 
											// ter o metodo execute
	public void execute(Scanner entrada) throws IOException {
		AnimalDAO ani = new AnimalDAO();

		System.out.println("Excluindo Animal...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();
		
		if (ani.getAnimalId(id) == null) {
			System.out.println("Nenhum animal com esse Id cadastrado");
		}
		else {
			ani.excluirAnimalVacina(id);// exclui o id do animal das tabelas relacionadas
			ani.excluir(id);// exclui da tabela animal
		}
	}
}
