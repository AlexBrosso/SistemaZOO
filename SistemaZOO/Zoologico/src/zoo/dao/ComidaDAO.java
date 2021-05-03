package zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zoo.cadastro.Comida;
import zoo.util.ConexaoZooFabrica;

public class ComidaDAO {
	public void inserir(Comida comida) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "insert into alimento (id, nome) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, comida.getId());
			ps.setString(2, comida.getNome());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Comida comida) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "update alimento set nome=? where id =?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, comida.getNome());
			ps.setInt(2, comida.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(int id) {
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from alimento where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Comida> getComidas(){//retorna todos os alimentos
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from alimento";
			PreparedStatement ps = conn.prepareStatement(sql);
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
	
	public ArrayList<Integer> getIdComidas(){//retorna o ids dos alimentos
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select id from alimento";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> comidas = new ArrayList<Integer>();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				comidas.add(id);
			}
			return comidas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluirComidaEspecie(int id) {//exclui da tabela especiealimento
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "delete from especiealimento where alimento_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Comida getComidaId(int id){//retorna a comida de acordo com o id
		try (Connection conn = ConexaoZooFabrica.getConexao()){
			String sql = "select * from alimento where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				Comida comida = new Comida(rs.getInt(1), 
											rs.getString(2));
				return comida;
			}
			return null;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
