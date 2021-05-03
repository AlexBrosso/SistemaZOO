package zoo.comando.animal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.AnimalDAO;
import zoo.dao.EspecieDAO;

public class AtualizarCarteiraVacinacao implements Comando {// implements comando herda class Comando, obrigando a
															// ter o metodo execute

	@Override
	public void execute(Scanner entrada) throws IOException {
		AnimalDAO ani = new AnimalDAO();
		EspecieDAO esp = new EspecieDAO();

		System.out.println("Digite o ID do Animal: ");
		int id = entrada.nextInt();

		if (ani.getAnimalId(id) == null) {// caso nao exista o ID
			System.out.println("Nenhuml animal com esse Id cadastrado");
		} else {// caso exista
			int idEspecie = ani.getAnimalId(id).getEspecieId();

			System.out.println("\nVACINAS NAO TOMADAS");
			for (Vacina vacina : ani.getAnimalVacinaNaoTomada(id)) {// retorna as vacinas que o animal ainda
				System.out.println(vacina.toString(1)); // nao tomou
			}
			
			System.out.println("\n\nVACINAS TOMADAS");
			for (Vacina vacina : ani.getAnimalVacinaTomadas(id)) {// retorna as vacinas que o animal tomou
				System.out.println(vacina.toString(1));
			}

			System.out.println("\nVacinas que o animal tomou (0 para finalizar): ");// ENCERRA EM 0
			int animalVacina = entrada.nextInt();

			ArrayList<Integer> vacinasTomadas = new ArrayList<Integer>();// armazena os ids das vacinas que
			while (animalVacina != 0) { // o usuario digitou

				vacinasTomadas.add(animalVacina);

				System.out.println("\nVacinas que o animal tomou (0 para finalizar): ");
				animalVacina = entrada.nextInt();
			}

			// compara os ids das vacinas que o usuario digitou com os ids das vacinas
			// existentes
			for (Integer vacinasEspecie : esp.getEspecieVacinaId(idEspecie)) {
				for (Integer vacina : vacinasTomadas) {
					if (vacinasEspecie == vacina) {
						ani.inserirAnimalVacina(id, vacina);// insere na tabela animaVacina do banco apenas as vacinas que faltam
					}
				}
			}
		}

	}

}
