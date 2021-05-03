package zoo.cadastro;

public abstract class Cadastro {
	private int id;
	private String nome;

	public Cadastro(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String toString() { // exibicao de dados sem escolha do usuario
		return "\n\nId: " + id + "\nNome: " + nome;
	}

	public String toString(int a) {// exibicao para orientar a escolha do usuario
		if (id < 10)
			return "| Id:" + id + "   |Nome: " + nome + "  |\n";
		else
			return "| Id:" + id + "  |Nome: " + nome + " |\n";

	}
}
