package zoo.comando.especie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import zoo.cadastro.Comida;
import zoo.comando.Comando;
import zoo.dao.ComidaDAO;
import zoo.dao.EspecieDAO;

public class AlterarComidaEspecie implements Comando {

	@Override
	public void execute(Scanner entrada) throws IOException {
		EspecieDAO esp = new EspecieDAO();
		ComidaDAO com = new ComidaDAO();

		System.out.println("Digite o ID da Especie: ");
		int id = entrada.nextInt();

		if (esp.getEspecieId(id) == null) {
			System.out.println("Nenhuma Especie com esse Id cadastrada");
		} 
		else {
			System.out.println("\n\n----------ALIMENTOS CADASTRADOS----------");
			for (Comida comida : com.getComidas()) {// retorna os alimentos cadastrados
				System.out.print(comida.toString(1));
			}

			System.out.println("\nAlimentos que a especie pode comer (0 para finalizar): ");// ENCERRA EM 0
			int comida = entrada.nextInt();

			ArrayList<Integer> especieCome = new ArrayList<Integer>();// armazena os ids dos alimentos digitados
			while (comida != 0) { // pelo user

				especieCome.add(comida);

				System.out.println("\nAlimentos que a especie pode comer(0 para finalizar): ");
				comida = entrada.nextInt();
			}

			esp.excluirEspecieComida(id); // exclui todos os alimentos antigos relacionados a especie na tabela
											// especieAlimento do banco

			// comparar para ver se a comida existe dentro da tabela alimentos do banco
			for (Integer comidasId : com.getIdComidas()) {
				for (Integer deveComer : especieCome) {
					if (comidasId == deveComer) {
						esp.inserirEspecieComida(id, comidasId);// armazena todas os novos alimentos na tabela
					} // especieAlimento do banco
				}
			}
		}
	}

}
