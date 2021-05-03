package zoo.comando.menu;

import java.io.IOException;
import java.util.Scanner;

import zoo.comando.Comando;
import zoo.util.ComandosFlyweight;

public class MenuEspecie implements Comando {
	public static void limpaTela() {
		for (int i = 0; i <= 5; i++) {
			System.out.println();
		}
	}

	public static void menu() {
		// MENU ANIMAL
		System.out.println("---------ZOO ESPÉCIE---------");
		System.out.println("(S)air");
		System.out.println("(C)adastrar (E)spécie");
		System.out.println("(A)lterar (E)spécie");
		System.out.println("(E)xcluir (E)spécie");
		System.out.println("(C)onsultar (ES)pécie");
		System.out.println("(A)lterar (V)acinas da (E)specie");
		System.out.println("(C)onsultar (V)acinas da (E)specie");
		System.out.println("(A)lterar (C)omidas da (E)specie");
		System.out.println("(C)onsultar (C)omidas da (E)specie");
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
