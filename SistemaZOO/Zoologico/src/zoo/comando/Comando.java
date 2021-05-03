package zoo.comando;

import java.io.IOException;
import java.util.Scanner;

public interface Comando {// interface de metodos abstratos que precisam existir nos filhos
	public abstract void execute(Scanner entrada) throws IOException;
}
