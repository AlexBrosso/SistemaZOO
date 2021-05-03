package zoo.comando.especie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import zoo.cadastro.Comida;
import zoo.cadastro.Especie;
import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.ComidaDAO;
import zoo.dao.EspecieDAO;
import zoo.dao.VacinaDAO;

public class CadastrarEspecie implements Comando {
	public void execute(Scanner entrada) throws IOException {
		EspecieDAO esp = new EspecieDAO();
		VacinaDAO vac = new VacinaDAO();
		ComidaDAO com = new ComidaDAO();
		System.out.println("\nCadastrando Especie...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();

		System.out.println("\nNome: ");
		String nome = entrada.next();

		System.out.println("\n\n----------VACINAS CADASTRADAS----------");
		for (Vacina vacina : vac.getVacinas()) {//retorna todas as vacinas cadastradas para orientar o user
			System.out.print(vacina.toString(1));
		}

		System.out.println("\nVacinas que a especie pode tomar (0 para finalizar): ");// ENCERRA EM 0
		int vacinaEspecie = entrada.nextInt();

		ArrayList<Integer> vacinasTomadas = new ArrayList<Integer>();//armazena os ids das vacinas que o user
		while (vacinaEspecie != 0) {								//digitou

			vacinasTomadas.add(vacinaEspecie);

			System.out.println("\nVacinas que a especie pode tomar (0 para finalizar): ");
			vacinaEspecie = entrada.nextInt();
		}

		System.out.println("\n\n----------ALIMENTOS CADASTRADOS----------");
		for (Comida comida : com.getComidas()) {//retorna todos os alimentos para orientar o user
			System.out.print(comida.toString(1));
		}

		System.out.println("\nAlimentos que a especie pode comer (0 para finalizar): ");// ENCERRA EM 0
		int comida = entrada.nextInt();

		ArrayList<Integer> especieCome = new ArrayList<Integer>();//armazena os ids dos alimentos que o user
		while (comida != 0) {									//digitou

			especieCome.add(comida);

			System.out.println("\nAlimentos que a especie pode comer (0 para finalizar): ");
			comida = entrada.nextInt();
		}

		Especie especie = new Especie(id, nome);
		esp.inserir(especie);

		// comparar para ver se a vacina existe dentro da tabela vacina
		for (Integer vacina : vac.getIdVacina()) {
			for (Integer deveAplicar : vacinasTomadas) {
				if (vacina == deveAplicar) {
					esp.inserirEspecieVacina(id, vacina);//insere na tabela especievacina
				}
			}
		}

		// comparar para ver se a comida existe dentro da tabela alimento
		for (Integer comidaId : com.getIdComidas()) {
			for (Integer deveComer : especieCome) {
				if (comidaId == deveComer) {
					esp.inserirEspecieComida(id, comidaId);//armazena na tabela especiealimento
				}
			}
		}

	}
}
