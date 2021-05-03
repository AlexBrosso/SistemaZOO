package zoo.comando.animal;

import java.io.IOException;
import java.util.Scanner;

import zoo.cadastro.Animal;
import zoo.cadastro.Especie;
import zoo.comando.Comando;
import zoo.dao.AnimalDAO;
import zoo.dao.EspecieDAO;

public class AlterarAnimal implements Comando {// implements comando herda class Comando, obrigando a 
												// ter o metodo execute

	public void execute(Scanner entrada) throws IOException {
		AnimalDAO ani = new AnimalDAO();
		EspecieDAO esp = new EspecieDAO();

		System.out.println("\nAlterando Animal...");

		System.out.println("\nId: ");
		int id = entrada.nextInt();
		
		if (ani.getAnimalId(id) == null) {
			System.out.println("Nenhum animal com esse Id cadastrado");
		}
		else {
			System.out.println("\nNome: ");
			String nome = entrada.next();
	
			System.out.println("\nData de Nascimento (YYYY - MM - DD): ");
			String nascimento = entrada.next();
	
			System.out.println("\nOrigem: ");
			String origem = entrada.next();
	
			System.out.println("\n\n----------ESPECIES CADASTRADAS----------");
			for (Especie especie : esp.getEspecies()) {// exibir todas as especies que ja foram cadastradas, para 
														// orientar o usuario
				System.out.print(especie.toString(1));
			}
	
			System.out.println("\nId da Especie: ");
			int especie = entrada.nextInt();
	
			Animal animal = new Animal(id, nome, nascimento, origem, especie);
	
			ani.alterar(animal);//update na tabela animal do banco
	
			System.out.println("\nPor favor atualize as vacinas do animal alterado no menu de animais!!!");
			ani.excluirAnimalVacina(id); // excluir da tabela animalvacina do banco por
											// causa de conflito em FK
		}

	}
}
