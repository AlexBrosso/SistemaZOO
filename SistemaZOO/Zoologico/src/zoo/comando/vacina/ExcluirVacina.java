package zoo.comando.vacina;

import java.io.IOException;
import java.util.Scanner;

import zoo.comando.Comando;
import zoo.dao.VacinaDAO;

public class ExcluirVacina implements Comando {
	public void execute(Scanner entrada) throws IOException {
		VacinaDAO vac = new VacinaDAO();

		System.out.println("Excluindo Vacina...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();

		if (vac.getVacinaId(id) == null) {
			System.out.println("Nenhuma vacina com esse Id cadastrada");
		}
		else {
			vac.excluirVacinaEspecie(id);// exclui da tabela especievacina por conta do FK
			vac.excluirVacinaAnimal(id);// exclui da tabela animalvacina por conta do FK
			vac.excluir(id);// exclui da tabela vacina
		}
	}
}
