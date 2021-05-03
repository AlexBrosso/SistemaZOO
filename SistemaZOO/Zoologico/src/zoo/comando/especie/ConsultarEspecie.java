package zoo.comando.especie;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Especie;
import zoo.comando.Comando;
import zoo.dao.EspecieDAO;

public class ConsultarEspecie implements Comando {
	public void execute(Scanner entrada) throws IOException {
		EspecieDAO esp = new EspecieDAO();
		for (Especie especie : esp.getEspecies()) {//retorna todas as especies
			System.out.println(especie);//exibe todas as infos da especie
		}
	}
}
