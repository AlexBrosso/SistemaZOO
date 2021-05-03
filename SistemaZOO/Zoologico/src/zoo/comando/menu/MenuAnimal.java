package zoo.comando.menu;

import java.io.IOException;
import java.util.Scanner;

import zoo.comando.Comando;
import zoo.util.ComandosFlyweight;

public class MenuAnimal implements Comando {
	public static void limpaTela() {
		for (int i = 0; i <= 5; i++) {
			System.out.println();
		}
	}

	public static void menu() {
		// MENU ANIMAL
		System.out.println("---------ZOO ANIMAL---------");
		System.out.println("(S)air");
		System.out.println("(C)adastrar (A)nimal");
		System.out.println("(A)lterar (A)nimal");
		System.out.println("(E)xcluir (A)nimal");
		System.out.println("(C)onsultar (AN)imal");
		System.out.println("(C)onsultar (AN)imal por (ID)");
		System.out.println("(C)onsultar (AN)imal por (E)specie");
		System.out.println("(A)tualizar (C)arteira de (V)acinacao");
		System.out.println("(C)onsultar (C)arteira de (V)acinacao");
		System.out.println("\nEscolha uma opcao: ");
	}

	@Override
	public void execute(Scanner entrada) throws IOException {

		ComandosFlyweight comandos = new ComandosFlyweight();
		String opcao;
		do {
			limpaTela();
			menu();
			opcao = entrada.next();// recebe a opcao que o user digitou
			comandos.getComando(opcao.toUpperCase()).execute(entrada);//chama o devido comando

		} while (!opcao.toUpperCase().equals("S"));
	}

}
