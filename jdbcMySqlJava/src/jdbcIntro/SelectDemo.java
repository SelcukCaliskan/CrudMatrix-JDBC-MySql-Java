package jdbcIntro;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SelectDemo extends DbHelper{
	DbHelper helper=new DbHelper();

	public void selectDemo() {
		
		ArrayList<Country> countries = new ArrayList<Country>();

		Statement statement = null;
		ResultSet resultSet;

		try {
			connection = helper.getConnection();
			System.out.println("Baðlantý oluþtu..");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select Code,Name,Continent,Region from country");
		
			while (resultSet.next()) {

				countries.add(new Country(resultSet.getString("Name"), resultSet.getString("Code"),
						resultSet.getString("Region"), resultSet.getString("Continent")));

			}
		
			System.out.println(countries.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				System.out.println("baðlantý kapatýldý.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
