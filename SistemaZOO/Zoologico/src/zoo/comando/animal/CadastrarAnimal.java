package zoo.comando.animal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import zoo.cadastro.Animal;
import zoo.cadastro.Especie;
import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.AnimalDAO;
import zoo.dao.EspecieDAO;

public class CadastrarAnimal implements Comando {// implements comando herda class Comando, obrigando a 
													// ter o metodo execute
	public void execute(Scanner entrada) throws IOException {
		AnimalDAO ani = new AnimalDAO();
		EspecieDAO esp = new EspecieDAO();

		System.out.println("\nCadastrando animal...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();

		System.out.println("\nNome: ");
		String nome = entrada.next();

		System.out.println("\nData de Nascimento  (YYYY - MM - DD): ");
		String nascimento = entrada.next();

		System.out.println("\nOrigem: ");
		String origem = entrada.next();

		System.out.println("\n\n----------ESPECIES CADASTRADAS----------");
		for (Especie especie : esp.getEspecies()) { // exibe as especies cadastradas para orientar o user
			System.out.print(especie.toString(1));
		}

		System.out.println("\n Id da especie: ");
		int especie = entrada.nextInt();

		System.out.println("\n\n----------VACINAS QUE A ESPECIE PODE TOMAR----------");
		for (Vacina vacina : esp.getEspecieVacina(especie)) {// exibe as vacinas cadastradas para
			System.out.print(vacina.toString(1)); // orientar o user
		}

		System.out.println("\nVacinas que o animal tomou (0 para finalizar): ");// ENCERRA EM 0
		int animalVacina = entrada.nextInt();

		ArrayList<Integer> vacinasTomadas = new ArrayList<Integer>(); // armazena os ids das vacinas que o user
		while (animalVacina != 0) { 									// digitou

			vacinasTomadas.add(animalVacina);

			System.out.println("\nVacinas que o animal tomou (0 para finalizar): ");
			animalVacina = entrada.nextInt();
		}

		Animal animal = new Animal(id, nome, nascimento, origem, especie);
		ani.inserir(animal);

		// compara os ids das vacinas que o user digitou com os ids das vacinas que a
		// especie do animal pode tomar
		for (Integer vacinaEspecie : esp.getEspecieVacinaId(especie)) {
			for (Integer vacina : vacinasTomadas) {
				if (vacinaEspecie == vacina) {
					ani.inserirAnimalVacina(id, vacina);
				}
			}
		}

	}
}
