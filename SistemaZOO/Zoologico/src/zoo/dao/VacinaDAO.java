package zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zoo.cadastro.Vacina;
import zoo.util.ConexaoZooFabrica;

public class VacinaDAO {
	public void inserir(Vacina vacina) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "insert into vacina (id, nome, descricao) values (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, vacina.getId());
			ps.setString(2, vacina.getNome());
			ps.setString(3, vacina.getDescricao());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Vacina vacina) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "update vacina set nome=?, descricao=? where id =?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vacina.getNome());
			ps.setString(2, vacina.getDescricao());
			ps.setInt(3, vacina.getId());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(int id) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from vacina where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Vacina> getVacinas(){//retorna todas as vacinas
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from vacina";
			PreparedStatement ps = conn.prepareStatement(sql);
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
	
	public ArrayList<Integer> getIdVacina(){//retorna os ids das vacinas
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select id from vacina";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> vacinas = new ArrayList<Integer>();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				vacinas.add(id);
			}
			return vacinas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirVacinaEspecie(int id) {//exclui vacina da tabela especievacina
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from especievacina where vacina_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirVacinaAnimal(int id) {//exclui a vacina da tabela animalvacina
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from animalvacina where vacina_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Vacina getVacinaId(int id){//retorna a vacina de acordo com o id
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from vacina where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				Vacina vacina = new Vacina(rs.getInt(1), 
											rs.getString(2),
											rs.getString(3));
				return vacina;
			}
			return null;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
