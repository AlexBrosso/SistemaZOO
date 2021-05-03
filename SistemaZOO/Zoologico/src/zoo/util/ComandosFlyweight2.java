package zoo.util;

import java.util.Hashtable;

import zoo.comando.Comando;
import zoo.comando.Sair;
import zoo.comando.menu.MenuAnimal;
import zoo.comando.menu.MenuComida;
import zoo.comando.menu.MenuEspecie;
import zoo.comando.menu.MenuVacina;

public class ComandosFlyweight2 {
	private Hashtable<String, Comando> comandos = new Hashtable<String, Comando>();

	public ComandosFlyweight2() {
		comandos.put("S", new Sair());
		comandos.put("MA", new MenuAnimal());
		comandos.put("ME", new MenuEspecie());
		comandos.put("MV", new MenuVacina());
		comandos.put("MC", new MenuComida());

	}

	public Comando getComando(String codigo) {
		return comandos.get(codigo);
	}
}
