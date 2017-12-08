package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conn.ConexaoMySQL;
import model.Produto;

public class ProdutoDAO {

	private static ProdutoDAO instance = null;
	private Connection conn = null;

	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}

	private void fecharConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Produto> findAll() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Produto> ps = new ArrayList<Produto>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Produto ORDER BY nome";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				ps.add(new Produto(result.getInt("idProduto"), result.getString("nome"),
						result.getString("descricao")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return ps;
	}

	public Produto findByID(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Produto p = null;
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Produto WHERE idProduto = " + id;
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				p = new Produto(result.getInt("idProduto"), result.getString("nome"), result.getString("descricao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return p;
	}

	public void inserir(Produto p) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			Statement state = conn.createStatement();
			String query = "INSERT INTO Produto(nome, descricao) VALUES('" + p.getNome() + "','" + p.getDescricao()
					+ "')";
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	public void atualizar(Produto p) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			Statement state = conn.createStatement();
			String query = "UPDATE Produto set nome = '" + p.getNome() + "', descricao = '" + p.getDescricao()
					+ "' WHERE idProduto = " + p.getId();
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	public void excluir(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			Statement state = conn.createStatement();
			String query = "DELETE FROM Produto WHERE idProduto = " + id;
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	public List<Produto> getProdutosCompra(Integer idCompra) {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Produto> ps = new ArrayList<Produto>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Produto p, Item_Compra ip WHERE ip.idProduto = p.idProduto AND ip.idCompra = "
					+ idCompra + " ORDER BY nome";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				ps.add(new Produto(result.getInt("p.idProduto"), result.getString("p.nome"),
						result.getString("p.descricao")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return ps;
	}

}
