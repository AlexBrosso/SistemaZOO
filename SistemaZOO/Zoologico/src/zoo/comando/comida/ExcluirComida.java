package zoo.comando.comida;

import java.io.IOException;
import java.util.Scanner;

import zoo.comando.Comando;
import zoo.dao.ComidaDAO;

public class ExcluirComida implements Comando {
	public void execute(Scanner entrada) throws IOException{
		ComidaDAO com = new ComidaDAO();
		
		System.out.println("Excluindo Comida...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();

		if (com.getComidaId(id) == null) {
			System.out.println("Nenhuma comida com esse Id cadastrada");
		}
		else {
			com.excluirComidaEspecie(id);//exclui da tabela relacionada por conta de FK
			com.excluir(id);//exclui alimento do banco
		}
	}
}
