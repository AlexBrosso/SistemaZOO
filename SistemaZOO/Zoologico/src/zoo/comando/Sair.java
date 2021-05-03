package zoo.comando;

import java.util.Scanner;

public class Sair implements Comando {// implements comando herda class Comando, obrigando a ter o metodo execute

	public void execute(Scanner entrada) {
		System.out.println("\n---------Finalizado---------\n\n");
	}

}
