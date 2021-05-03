package zoo.comando.especie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import zoo.cadastro.Vacina;
import zoo.comando.Comando;
import zoo.dao.EspecieDAO;

public class ConsultarVacinasEspecie implements Comando {

	@Override
	public void execute(Scanner entrada) throws IOException {
		EspecieDAO esp = new EspecieDAO();
		
		System.out.println("Digite o id da especie a ser buscado: ");
		int id = entrada.nextInt();
		
		List<Vacina> especieVacina = new ArrayList<Vacina>();
		especieVacina = esp.getEspecieVacina(id);//retorna todas as vacinas que a especie pode tomar
		
		if (especieVacina.isEmpty()) {
			System.out.println("Nenhuml animal com essa especie cadastrado");
			
		}
		else {
			for (Vacina vac : especieVacina ) {
				System.out.println(vac.toString(1));//exibe apenas o id e o nome formatado das vacinas que a especie pode tomar
			}
		}
		
	}

}
