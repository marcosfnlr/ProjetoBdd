package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conn.ConexaoMySQL;
import model.Compra;

public class CompraDAO {

	private static CompraDAO instance = null;
	private Connection conn = null;

	public static CompraDAO getInstance() {
		if (instance == null) {
			instance = new CompraDAO();
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

	public List<Compra> findAll() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Compra> cs = new ArrayList<Compra>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Compra ORDER BY data";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				cs.add(new Compra(result.getInt("idCompra"), result.getDate("data"), result.getDouble("preco"),
						result.getInt("funcionario_responsavel"), result.getInt("idFornecedor")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return cs;
	}

	public Compra findByID(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Compra c = null;
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Compra WHERE idCompra = " + id;
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				c = new Compra(result.getInt("idCompra"), result.getDate("data"), result.getDouble("preco"),
						result.getInt("funcionario_responsavel"), result.getInt("idFornecedor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return c;
	}

	public void inserir(Compra c) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			Statement state = conn.createStatement();
			String query = "INSERT INTO Compra(data, preco, funcionario_responsavel, idFornecedor) VALUES("
					+ c.getData() + "," + c.getPreco() + ", " + c.getIdFuncionario() + ", " + c.getIdFornecedor() + ")";
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
			String query = "DELETE FROM Compra WHERE idCompra = " + id;
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

}
