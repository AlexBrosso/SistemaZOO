package zoo.menu;

import java.io.IOException;
import java.util.Scanner;

import zoo.util.ComandosFlyweight2;

public class GerenciaMenu {
	public static void menu() {
		System.out.println("---------Administração ZOO---------");

		// MENU INICIO
		System.out.println("(S)air");
		System.out.println("(M)enu (A)nimal");
		System.out.println("(M)enu (E)spécie");
		System.out.println("(M)enu (V)acina");
		System.out.println("(M)enu (C)omida");
		System.out.println("\nEscolha uma opcao: ");
	}

	public static void limpaTela() {
		for (int i = 0; i <= 5; i++) {
			System.out.println();
		}
	}

	public static void menuEsc() {
		Scanner entrada = new Scanner(System.in);

		ComandosFlyweight2 comandos = new ComandosFlyweight2();
		String opcao;
		do {
			menu();
			opcao = entrada.next();//recebe a opcao do user
			limpaTela();
			try {
				comandos.getComando(opcao.toUpperCase()).execute(entrada);//executa o devido comando

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} while (!opcao.toUpperCase().equals("S"));

		entrada.close();
	}

}
