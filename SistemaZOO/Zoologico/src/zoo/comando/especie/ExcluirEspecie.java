package zoo.comando.especie;

import java.io.IOException;
import java.util.Scanner;

import zoo.comando.Comando;
import zoo.dao.EspecieDAO;

public class ExcluirEspecie implements Comando {
	public void execute(Scanner entrada) throws IOException{
		EspecieDAO esp = new EspecieDAO();
		
		System.out.println("Excluindo Especie...");
		System.out.println("\nATENCAO: Ao excluir a especie, as vacinas, comidas e animais associados a especie serao tambem excluidos!!");

		System.out.println("\nId: ");
		int id = entrada.nextInt();
		
		if (esp.getEspecieId(id) == null) {
			System.out.println("Nenhuma especie com esse Id cadastrada");
		}
		else {
			esp.excluirEspecieVacina(id); //exclui da tabela especievacina por conta do FK
			esp.excluirEspecieComida(id);//exclui da tabela especiealimento por conta do FK
			esp.excluirEspecieAnimalVacina(id);//exclui da tabela animalvacina por conta do FK
			esp.excluirEspecieAnimal(id);//exclui da tabela animal por conta do FK
			esp.excluir(id);//exclui da tabela especie
		}
		
	}
}
