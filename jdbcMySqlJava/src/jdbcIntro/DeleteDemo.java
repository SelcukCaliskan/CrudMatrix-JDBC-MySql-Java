package jdbcIntro;

import java.sql.SQLException;

public class DeleteDemo extends DbHelper {
	DbHelper helper = new DbHelper();

	public void delete() {

		java.sql.PreparedStatement statement = null;// Ýnsert için kullanýlýr

		try {
			connection = helper.getConnection();

			System.out.println("Baðlantý oluþtu..");

			statement = connection.prepareStatement(
					"delete from city where  (Name,CountryCode,District,Population) = ('YOZGAT','TUR','ANKARA',50.000)");

			System.out.println("Kayýt silindi..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();// kapatýldý
				connection.close();
				System.out.println("baðlantý kapatýldý.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
