package zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zoo.cadastro.Animal;
import zoo.cadastro.Vacina;
import zoo.util.ConexaoZooFabrica;

public class AnimalDAO {
	public void inserir(Animal animal) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "insert into animal (id, nome, nascimento, origem, especie_id ) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, animal.getId());
			ps.setString(2, animal.getNome());
			ps.setString(3, animal.getNascimento());
			ps.setString(4, animal.getOrigem());
			ps.setInt(5, animal.getEspecieId());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Animal animal) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "update animal set nome=?, nascimento=?, origem=?, especie_id=? where id =?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, animal.getNome());
			ps.setString(2, animal.getNascimento());
			ps.setString(3, animal.getOrigem());
			ps.setInt(4, animal.getEspecieId());
			ps.setInt(5, animal.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(int id) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from animal where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Animal> getAnimais(){ //retorna todos os animais
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from animal";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Animal> animais = new ArrayList<Animal>();
			
			while (rs.next()) {
				Animal animal = new Animal(rs.getInt(1), 
											rs.getString(2),
											rs.getString(3),
											rs.getString(4),
											rs.getInt(5));
				animais.add(animal);
			}
			return animais;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Animal> getAnimaisEspecie(int idEsp){//retorna os animais com a especie desejada
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from animal where especie_id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idEsp);
			
			ResultSet rs = ps.executeQuery();
			List<Animal> animais = new ArrayList<Animal>();
			
			while (rs.next()) {
				Animal animal = new Animal(rs.getInt(1), 
											rs.getString(2),
											rs.getString(3),
											rs.getString(4),
											rs.getInt(5));
				animais.add(animal);
			}
			return animais;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Animal getAnimalId(int id){//retorna os dados do animal de acordo com seu id
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from animal where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				Animal animal = new Animal(rs.getInt(1), 
											rs.getString(2),
											rs.getString(3),
											rs.getString(4),
											rs.getInt(5));
				return animal;
			}
			return null;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//INSERIR NA TEBELA ANIMALVACINA
	public void inserirAnimalVacina(int id, int idVac) {//insere na tabela animalvacina
		try (Connection conn = ConexaoZooFabrica.getConexao()){//try with resources
			String sql = "insert into animalvacina (animal_id, vacina_id) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.setInt(2, idVac);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Vacina> getAnimalVacinaNaoTomada(int id){//retorna as vacinas nao tomadas de acordo com a especie do animal
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "SELECT especievacina.vacina_id, vacina.nome, vacina.descricao FROM animal, vacina "
					+ "INNER JOIN especie ON animal.especie_id = especie.id "
					+ "INNER JOIN especievacina ON animal.especie_id = especievacina.especie_id "
					+ "LEFT JOIN animalvacina "
					+ "    on especievacina.vacina_id = animalvacina.vacina_id and animal.id = animalvacina.animal_id "
					+ "WHERE animalvacina.vacina_id IS NULL and animal.id = ? and  especievacina.vacina_id = vacina.id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			List<Vacina> vacinas = new ArrayList<Vacina>();
			
			while (rs.next()) {
				Vacina vacina = new Vacina(rs.getInt(1), 
											rs.getString(2),
											rs.getString(3));
				vacinas.add(vacina);
			}
			return vacinas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Vacina> getAnimalVacinaTomadas(int id){//retorna as vacinas tomadas de acordo com a especie do animal
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "SELECT animalvacina.vacina_id, vacina.nome, vacina.descricao FROM animalvacina join vacina on animalvacina.vacina_id = vacina.id where animalvacina.animal_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			List<Vacina> vacinas = new ArrayList<Vacina>();
			
			while (rs.next()) {
				Vacina vacina = new Vacina(rs.getInt(1), 
											rs.getString(2),
											rs.getString(3));
				vacinas.add(vacina);
			}
			return vacinas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirAnimalVacina(int id) {//exclui da tabela animalvacina
		try (Connection conn = ConexaoZooFabrica.getConexao()){//try with resources
			String sql = "delete from animalvacina where animal_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
