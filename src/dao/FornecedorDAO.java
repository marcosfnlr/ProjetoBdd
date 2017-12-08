package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conn.ConexaoMySQL;
import model.Fornecedor;

public class FornecedorDAO {

	private static FornecedorDAO instance = null;
	private Connection conn = null;

	public static FornecedorDAO getInstance() {
		if (instance == null) {
			instance = new FornecedorDAO();
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

	public List<Fornecedor> findAll() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Fornecedor> fs = new ArrayList<Fornecedor>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Fornecedor ORDER BY razao_social";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				fs.add(new Fornecedor(result.getInt("idFornecedor"), result.getString("razao_social"),
						result.getString("cnpj")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return fs;
	}

	public Fornecedor findByID(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Fornecedor f = null;
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Fornecedor WHERE idFornecedor = " + id;
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				f = new Fornecedor(result.getInt("idFornecedor"), result.getString("razao_social"),
						result.getString("cnpj"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return f;
	}

	public void inserir(Fornecedor f) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			Statement state = conn.createStatement();
			String query = "INSERT INTO Fornecedor(razao_social, cnpj) VALUES('" + f.getRazaoSocial() + "','"
					+ f.getCnpj() + "')";
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	public void atualizar(Fornecedor f) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			Statement state = conn.createStatement();
			String query = "UPDATE Fornecedor set razao_social = '" + f.getRazaoSocial() + "', cnpj = '" + f.getCnpj()
					+ "' WHERE idFornecedor = " + f.getId();
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
			String query = "DELETE FROM Fornecedor WHERE idFornecedor = " + id;
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

}
