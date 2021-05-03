package zoo.comando.animal;

import java.io.IOException;
import java.util.Scanner;

import zoo.comando.Comando;
import zoo.dao.AnimalDAO;

public class ConsultarIdAnimal implements Comando {// implements comando herda class Comando, obrigando a 
													// ter o metodo execute
	public void execute(Scanner entrada) throws IOException {
		AnimalDAO ani = new AnimalDAO();

		System.out.println("Digite o id do animal a ser buscado: ");
		int id = entrada.nextInt();

		if (ani.getAnimalId(id) == null) {
			System.out.println("Nenhuml animal com esse Id cadastrado");
		} 
		else {
			System.out.println(ani.getAnimalId(id));// exibe todas as informacoes do animal, nao apenas id e nome
		}

	}
}
