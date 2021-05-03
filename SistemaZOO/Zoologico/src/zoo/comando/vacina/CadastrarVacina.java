package zoo.comando.vacina;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.VacinaDAO;

public class CadastrarVacina implements Comando {
	public void execute(Scanner entrada) throws IOException {
		VacinaDAO vac = new VacinaDAO();
		System.out.println("\nCadastrando vacina...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();

		System.out.println("\nNome: ");
		String nome = entrada.next();

		System.out.println("\nDescricao: ");
		String descricao = entrada.next();

		Vacina vacina = new Vacina(id, nome, descricao);
		vac.inserir(vacina);// insere na tabela vacina
	}
}
