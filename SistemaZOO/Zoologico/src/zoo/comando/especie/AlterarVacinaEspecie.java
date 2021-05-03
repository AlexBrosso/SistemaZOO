package zoo.comando.especie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.EspecieDAO;
import zoo.dao.VacinaDAO;

public class AlterarVacinaEspecie implements Comando {

	@Override
	public void execute(Scanner entrada) throws IOException {

		EspecieDAO esp = new EspecieDAO();
		VacinaDAO vac = new VacinaDAO();

		System.out.println("Digite o ID da Especie: ");
		int id = entrada.nextInt();

		if (esp.getEspecieId(id) == null) {
			System.out.println("Nenhuma Especie com esse Id cadastrada");
		} 
		else {
			System.out.println("\n\n----------VACINAS CADASTRADAS----------");
			for (Vacina vacina : vac.getVacinas()) {// retorna todas as vacinas para orientar o user
				System.out.print(vacina.toString(1));
			}

			System.out.println("\nVacinas que a especie pode tomar (0 para finalizar): ");// ENCERRA EM 0
			int especielVacina = entrada.nextInt();

			ArrayList<Integer> vacinasTomadas = new ArrayList<Integer>();// armazena as vacinas digitadas
			while (especielVacina != 0) { // pelo user

				vacinasTomadas.add(especielVacina);

				System.out.println("\nVacinas que a especie pode tomar (0 para finalizar): ");
				especielVacina = entrada.nextInt();
			}

			esp.excluirEspecieAnimalVacina(id); // exclui da tabela animalVacina que esta vinculada com especie
			esp.excluirEspecieVacina(id);// exclui da tabela especieVacina que esta vinculada com especie

			// comparar para ver se a vacina existe
			for (Integer vacina : vac.getIdVacina()) {
				for (Integer deveAplicar : vacinasTomadas) {
					if (vacina == deveAplicar) {
						esp.inserirEspecieVacina(id, vacina);//insere os novos valores na tabela especieVacina
					}
				}
			}

			System.out.println(
					"\nATENCAO: Alguns animais com esse ID de especie podem estar com suas Carteiras de Vacinacao desatualizadas!");
		}
	}

}
