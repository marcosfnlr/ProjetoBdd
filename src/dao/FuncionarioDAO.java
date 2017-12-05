package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conn.ConexaoMySQL;
import model.Funcionario;

public class FuncionarioDAO {

	private static FuncionarioDAO instance = null;
	private Connection conn = null;

	public static FuncionarioDAO getInstance() {
		if (instance == null) {
			instance = new FuncionarioDAO();
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

	public List<Funcionario> findAll() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Funcionario> fs = new ArrayList<Funcionario>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Funcionario ORDER BY nome";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				fs.add(new Funcionario(result.getInt("idFuncionario"), result.getString("nome"), result.getInt("cpf"),
						result.getString("email"), result.getInt("idCargo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return fs;
	}

	public Funcionario findByID(Integer id) {
		conn = ConexaoMySQL.getConexaoMySQL();
		Funcionario f = null;
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Funcionario WHERE idFuncionario = " + id;
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				f = new Funcionario(result.getInt("idFuncionario"), result.getString("nome"), result.getInt("cpf"),
						result.getString("email"), result.getInt("idCargo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return f;
	}

	public void inserir(Funcionario f) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			Statement state = conn.createStatement();
			String query = "INSERT INTO Funcionario(nome, cpf, idCargo, email) VALUES('" + f.getNome() + "',"
					+ f.getCpf() + "," + f.getIdCargo() + ",'" + f.getEmail() + "')";
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	public void atualizar(Funcionario f) {
		conn = ConexaoMySQL.getConexaoMySQL();
		try {
			Statement state = conn.createStatement();
			String query = "UPDATE Funcionario set nome = '" + f.getNome() + "', cpf = " + f.getCpf() + ", idCargo = "
					+ f.getIdCargo() + ",  email = '" + f.getEmail() + "' WHERE idFuncionario = " + f.getId();
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
			String query = "DELETE FROM Funcionario WHERE idFuncionario = " + id;
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

}
