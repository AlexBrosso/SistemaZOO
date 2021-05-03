package zoo.comando.vacina;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.VacinaDAO;

public class AlterarVacina implements Comando {
	public void execute(Scanner entrada) throws IOException {
		VacinaDAO vac = new VacinaDAO();

		System.out.println("\nAlterando vacina...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();
		
		if (vac.getVacinaId(id) == null) {
			System.out.println("Nenhuma vacina com esse Id cadastrada");
		}
		else {
			System.out.println("\nNome: ");
			String nome = entrada.next();
	
			System.out.println("\nDescricao: ");
			String descricao = entrada.next();
	
			Vacina vacina = new Vacina(id, nome, descricao);
	
			vac.alterar(vacina);// update table vacina
		}
	}
}
