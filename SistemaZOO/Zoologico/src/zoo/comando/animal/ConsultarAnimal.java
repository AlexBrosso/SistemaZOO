package zoo.comando.animal;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Animal;
import zoo.comando.Comando;
import zoo.dao.AnimalDAO;

public class ConsultarAnimal implements Comando {// implements comando herda class Comando, obrigando a 
													// ter o metodo execute

	public void execute(Scanner entrada) throws IOException {
		AnimalDAO ani = new AnimalDAO();
		for (Animal animal : ani.getAnimais()) {// retorna todos os animais cadastrados
			System.out.println(animal);
		}
	}
}
