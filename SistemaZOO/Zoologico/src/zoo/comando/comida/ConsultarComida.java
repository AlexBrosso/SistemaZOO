package zoo.comando.comida;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Comida;
import zoo.comando.Comando;
import zoo.dao.ComidaDAO;


public class ConsultarComida implements Comando{
	public void execute(Scanner entrada) throws IOException{
		ComidaDAO com = new ComidaDAO();
		for (Comida comida : com.getComidas()) { //retorna os alimentos cadastrados no banco
			System.out.println(comida);
		}
	}
}
