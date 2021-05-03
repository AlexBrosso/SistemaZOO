package zoo.cadastro;

public class Vacina extends Cadastro {
	private String descricao;

	public Vacina(int id, String nome, String descricao) {
		super(id, nome);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {// adiciona as demais infos de vacina
		return super.toString() + "\nDescricao: " + getDescricao();
	}

}
