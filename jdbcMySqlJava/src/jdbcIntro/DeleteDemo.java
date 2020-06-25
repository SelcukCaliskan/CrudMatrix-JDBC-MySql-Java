package jdbcIntro;

import java.sql.SQLException;

public class DeleteDemo extends DbHelper {
	DbHelper helper = new DbHelper();

	public void delete() {

		java.sql.PreparedStatement statement = null;// �nsert i�in kullan�l�r

		try {
			connection = helper.getConnection();

			System.out.println("Ba�lant� olu�tu..");

			statement = connection.prepareStatement(
					"delete from city where  (Name,CountryCode,District,Population) = ('YOZGAT','TUR','ANKARA',50.000)");

			System.out.println("Kay�t silindi..");
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
