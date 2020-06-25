package jdbcIntro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

	private String userName = "root";
	private String db_url = "jdbc:mysql://localhost:3306/world?useSSL=false";
	private String password = "12345";

	Connection connection = null;

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(db_url, userName, password);

	}
}
