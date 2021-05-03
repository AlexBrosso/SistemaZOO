package zoo.comando.menu;

import java.io.IOException;
import java.util.Scanner;

import zoo.comando.Comando;
import zoo.util.ComandosFlyweight;

public class MenuComida implements Comando {
	public static void limpaTela() {
		for (int i = 0; i <= 5; i++) {
			System.out.println();
		}
	}

	public static void menu() {
		// MENU ANIMAL
		System.out.println("---------ZOO COMIDA---------");
		System.out.println("(S)air");
		System.out.println("(C)adastrar (C)omida");
		System.out.println("(A)lterar (C)omida");
		System.out.println("(E)xcluir (C)omida");
		System.out.println("(C)onsultar (CO)mida");
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
