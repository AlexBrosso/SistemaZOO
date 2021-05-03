package zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zoo.cadastro.Comida;
import zoo.cadastro.Especie;
import zoo.cadastro.Vacina;
import zoo.util.ConexaoZooFabrica;



public class EspecieDAO {
	public void inserir(Especie especie) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "insert into especie (id, nome) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, especie.getId());
			ps.setString(2, especie.getNome());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Especie especie) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "update especie set nome=? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, especie.getNome());
			ps.setInt(2, especie.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(int id) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from especie where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Especie> getEspecies(){//retorna todas as especies
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from especie";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Especie> especies = new ArrayList<Especie>();
			
			while (rs.next()) {
				Especie especie = new Especie(rs.getInt(1), 
											rs.getString(2));
				especies.add(especie);
			}
			return especies;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Especie getEspecieId(int id){//retorna a especie de acordo com o id
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from especie where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				Especie especie = new Especie(rs.getInt(1), 
											rs.getString(2));
				return especie;
			}
			return null;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//INSERIR NA TEBELA ESPECIEVACINA
	public void inserirEspecieVacina(int id, int idVacina) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "insert into especievacina (especie_id, vacina_id) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.setInt(2, idVacina);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//INSERIR NA TEBELA ESPECIEALIMENTO
	public void inserirEspecieComida(int id, int idComida) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "insert into especiealimento (especie_id, alimento_id) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.setInt(2, idComida);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//RETORNAR VACINAS DA TABELA ESPECIEVACINA
	public List<Vacina> getEspecieVacina(int id) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select vacina.id, vacina.nome, vacina.descricao from especievacina join vacina on especievacina.vacina_id = vacina.id join especie on  especievacina.especie_id = especie.id where especie.id = ?";
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
	
	public List<Integer> getEspecieVacinaId(int id) {//retorna as ids das vacinas que a especie pode tomar
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select vacina.id from especievacina join vacina on especievacina.vacina_id = vacina.id join especie on  especievacina.especie_id = especie.id where especie.id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Integer> vacinas = new ArrayList<Integer>();
			
			while (rs.next()) {
				int idVac = rs.getInt(1);
				vacinas.add(idVac);
			}
			return vacinas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Comida> getEspecieComida(int id) {//retorna os alimentos que a especie pode comer
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select alimento.id, alimento.nome from especiealimento join alimento on especiealimento.alimento_id = alimento.id join especie on  especiealimento.especie_id = especie.id where especie.id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			List<Comida> comidas = new ArrayList<Comida>();
			
			while (rs.next()) {
				Comida comida = new Comida(rs.getInt(1), 
										   rs.getString(2));
				comidas.add(comida);
			}
			return comidas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirEspecieVacina(int id) {//exclui a especie da tabela especievacina
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from especievacina where especie_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirEspecieComida(int id) {//exclui a especie da tabela especiealimento
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from especiealimento where especie_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirEspecieAnimalVacina(int id) {//exclui o animal que possui a especie da tabela animavacina
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from animalvacina "
					+ "where animalvacina.animal_id IN (select animalvacina.animal_id from animalvacina join animal "
					+ "on animal.id = animalvacina.animal_id and animal.especie_id  = ?) ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirEspecieAnimal(int id) {//exclui o animal que possui a especie da tabela animal
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from animal where especie_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
