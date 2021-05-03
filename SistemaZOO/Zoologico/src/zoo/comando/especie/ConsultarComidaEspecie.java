package zoo.comando.especie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import zoo.cadastro.Comida;
import zoo.comando.Comando;
import zoo.dao.EspecieDAO;

public class ConsultarComidaEspecie implements Comando {

	@Override
	public void execute(Scanner entrada) throws IOException {
		EspecieDAO esp = new EspecieDAO();

		System.out.println("Digite o id da especie a ser buscado: ");
		int id = entrada.nextInt();

		List<Comida> consultaComidaEspecie = new ArrayList<Comida>();
		consultaComidaEspecie = esp.getEspecieComida(id);// retorna os alimentos de acordo com a especie, da tabela
															// especieAlimento

		if (consultaComidaEspecie.isEmpty()) {
			System.out.println("Nenhuma comida cadastrada na espécie");

		} 
		else {
			for (Comida com : consultaComidaEspecie) {
				System.out.println(com.toString());// exibe todos os dados do alimento
			}
		}

	}

}
