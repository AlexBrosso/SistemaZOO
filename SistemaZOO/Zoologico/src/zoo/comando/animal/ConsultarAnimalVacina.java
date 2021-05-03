package zoo.comando.animal;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.AnimalDAO;

public class ConsultarAnimalVacina implements Comando {// implements comando herda class Comando, obrigando a 
													// ter o metodo execute

	public void execute(Scanner entrada) throws IOException {
		AnimalDAO ani = new AnimalDAO();

		System.out.println("Digite o id do animal a ser buscado: ");
		int id = entrada.nextInt();

		if (ani.getAnimalId(id) == null) {
			System.out.println("Nenhuml animal com esse Id cadastrado");
		} 
		else {
			System.out.println("\nVACINAS NAO TOMADAS");
			for (Vacina vacina : ani.getAnimalVacinaNaoTomada(id)) {//retorna as vacinas que o animal ainda
				System.out.println(vacina.toString(1));				//nao tomou
			}
			System.out.println("\n\nVACINAS TOMADAS");
			for (Vacina vacina : ani.getAnimalVacinaTomadas(id)) {//retorna as vacinas que o animal tomou
				System.out.println(vacina.toString(1));
			}
		}

	}

}
