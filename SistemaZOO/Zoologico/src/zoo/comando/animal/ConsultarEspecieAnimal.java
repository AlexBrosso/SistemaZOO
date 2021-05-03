package zoo.comando.animal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import zoo.cadastro.Animal;
import zoo.cadastro.Especie;
import zoo.comando.Comando;
import zoo.dao.AnimalDAO;
import zoo.dao.EspecieDAO;

public class ConsultarEspecieAnimal implements Comando {// implements comando herda class Comando, obrigando a 
														// ter o metodo execute
	public void execute(Scanner entrada) throws IOException {
		AnimalDAO ani = new AnimalDAO();
		EspecieDAO esp = new EspecieDAO();
		
		System.out.println("\n\n----------ESPECIES CADASTRADAS----------");
		for (Especie especie : esp.getEspecies()) { // exibe as especies cadastradas para orientar o user
			System.out.print(especie.toString(1));
		}

		System.out.println("\nDigite o id da especie do animal a ser buscado: ");
		int id = entrada.nextInt();

		List<Animal> animais = new ArrayList<Animal>();
		animais = ani.getAnimaisEspecie(id);//retorna todos os animais com a especie digitada pelo usuario

		if (animais.isEmpty()) {
			System.out.println("Nenhuml animal com essa especie cadastrado");

		} else {
			for (Animal animal : animais) {
				System.out.println(animal);
			}
		}

	}
}
