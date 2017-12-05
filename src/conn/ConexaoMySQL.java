package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static Connection getConexaoMySQL() {

		Connection connection = null;
		try {

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			String username = "root";
			String password = "admin";

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoBDD", username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

}
