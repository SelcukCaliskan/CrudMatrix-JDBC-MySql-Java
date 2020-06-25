package jdbcIntro;

import java.sql.SQLException;

public class InsertDemo extends DbHelper {
	DbHelper helper = new DbHelper();

	public void insert() {

		java.sql.PreparedStatement statement = null;// Ýnsert için kullanýlýr

		try {
			connection = helper.getConnection();
			System.out.println("Baðlantý oluþtu..");

			statement = connection.prepareStatement(
					"insert into city(Name,CountryCode,District,Population) values ('YOZGAT','TUR','Çorum',50.000)");

			int result = statement.executeUpdate(); // burda bize yeni oluþan veriyi günceller.//int result ekledik

			System.out.println("Kayýt eklendi..");
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
