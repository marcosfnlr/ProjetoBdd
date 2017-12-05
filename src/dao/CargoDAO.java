package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conn.ConexaoMySQL;
import model.Cargo;

public class CargoDAO {
	private static CargoDAO instance = null;
	private Connection conn = null;

	public static CargoDAO getInstance() {
		if (instance == null) {
			instance = new CargoDAO();
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

	public List<Cargo> findAll() {
		conn = ConexaoMySQL.getConexaoMySQL();
		ArrayList<Cargo> cs = new ArrayList<Cargo>();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM Cargo ORDER BY titulo";
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				cs.add(new Cargo(result.getInt("idCargo"), result.getString("titulo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return cs;
	}
}
