package zoo.cadastro;

public class Animal extends Cadastro {
	private String nascimento;
	private String origem;
	private int especieId;

	public Animal(int id, String nome, String nascimento, String origem, int especieId) {
		super(id, nome);
		this.nascimento = nascimento;
		this.origem = origem;
		this.especieId = especieId;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public int getEspecieId() {
		return especieId;
	}

	public void setEspecieId(int especieId) {
		this.especieId = especieId;
	}

	public String toString() { //toString com o resto das informacoes da classe
		return super.toString() + "\nData de nascimento: " + getNascimento() + "\nOrigem: " + getOrigem()
				+ "\nEspecie Id: " + getEspecieId();
	}
}
