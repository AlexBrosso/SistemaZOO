package zoo.util;

import java.util.Hashtable;

import zoo.comando.Comando;
import zoo.comando.Sair;
import zoo.comando.animal.AlterarAnimal;
import zoo.comando.animal.AtualizarCarteiraVacinacao;
import zoo.comando.animal.CadastrarAnimal;
import zoo.comando.animal.ConsultarAnimal;
import zoo.comando.animal.ConsultarAnimalVacina;
import zoo.comando.animal.ConsultarEspecieAnimal;
import zoo.comando.animal.ConsultarIdAnimal;
import zoo.comando.animal.ExcluirAnimal;
import zoo.comando.comida.AlterarComida;
import zoo.comando.comida.CadastrarComida;
import zoo.comando.comida.ConsultarComida;
import zoo.comando.comida.ExcluirComida;
import zoo.comando.especie.AlterarComidaEspecie;
import zoo.comando.especie.AlterarEspecie;
import zoo.comando.especie.AlterarVacinaEspecie;
import zoo.comando.especie.CadastrarEspecie;
import zoo.comando.especie.ConsultarComidaEspecie;
import zoo.comando.especie.ConsultarEspecie;
import zoo.comando.especie.ConsultarVacinasEspecie;
import zoo.comando.especie.ExcluirEspecie;
import zoo.comando.vacina.AlterarVacina;
import zoo.comando.vacina.CadastrarVacina;
import zoo.comando.vacina.ConsultarVacina;
import zoo.comando.vacina.ExcluirVacina;

public class ComandosFlyweight {
	private Hashtable<String, Comando> comandos = new Hashtable<String, Comando>();

	public ComandosFlyweight() {

		comandos.put("S", new Sair());
		comandos.put("CA", new CadastrarAnimal());
		comandos.put("CE", new CadastrarEspecie());
		comandos.put("CV", new CadastrarVacina());
		comandos.put("CC", new CadastrarComida());
		comandos.put("AA", new AlterarAnimal());
		comandos.put("AE", new AlterarEspecie());
		comandos.put("AV", new AlterarVacina());
		comandos.put("AC", new AlterarComida());
		comandos.put("EA", new ExcluirAnimal());
		comandos.put("EE", new ExcluirEspecie());
		comandos.put("EV", new ExcluirVacina());
		comandos.put("EC", new ExcluirComida());
		comandos.put("CAN", new ConsultarAnimal());
		comandos.put("CES", new ConsultarEspecie());
		comandos.put("CVA", new ConsultarVacina());
		comandos.put("CCO", new ConsultarComida());
		comandos.put("CANID", new ConsultarIdAnimal());
		comandos.put("CANE", new ConsultarEspecieAnimal());
		comandos.put("CCV", new ConsultarAnimalVacina());
		comandos.put("AVE", new AlterarVacinaEspecie());
		comandos.put("ACE", new AlterarComidaEspecie());
		comandos.put("ACV", new AtualizarCarteiraVacinacao());
		comandos.put("CVE", new ConsultarVacinasEspecie());
		comandos.put("CCE", new ConsultarComidaEspecie());

	}

	public Comando getComando(String codigo) {
		return comandos.get(codigo);
	}
}
