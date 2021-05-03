package zoo.comando.vacina;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.VacinaDAO;

public class ConsultarVacina implements Comando {
	public void execute(Scanner entrada) throws IOException {
		VacinaDAO vac = new VacinaDAO();
		for (Vacina vacina : vac.getVacinas()) {// retorna todas as vacinas
			System.out.println(vacina);// exibe todas as infos das vacinas
		}
	}
}
