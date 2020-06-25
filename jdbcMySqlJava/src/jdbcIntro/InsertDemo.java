package jdbcIntro;

import java.sql.SQLException;

public class InsertDemo extends DbHelper {
	DbHelper helper = new DbHelper();

	public void insert() {

		java.sql.PreparedStatement statement = null;// �nsert i�in kullan�l�r

		try {
			connection = helper.getConnection();
			System.out.println("Ba�lant� olu�tu..");

			statement = connection.prepareStatement(
					"insert into city(Name,CountryCode,District,Population) values ('YOZGAT','TUR','�orum',50.000)");

			int result = statement.executeUpdate(); // burda bize yeni olu�an veriyi g�nceller.//int result ekledik

			System.out.println("Kay�t eklendi..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();// kapat�ld�
				connection.close();
				System.out.println("ba�lant� kapat�ld�.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
