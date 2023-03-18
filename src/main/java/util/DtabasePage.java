package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DtabasePage {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	String columnValue = null;

	public String getDtaFromDb(String columName) {

		try {

			// setting properties of mySql
			Class.forName("com.mysql.cj.jdbc.Driver"); // google-d  java mysql jdbc
			String sqlUrl = "jdbc:mysql://localhost:3306/jully2022"; // this given by devalopper//hostname and port
																		// number from manage connection
			String sqlUrlUsername = "root";
			String sqlUrlpassword = "Tn++1501";
			String sqlquery = "select * from users";

			// create connection to local database
			connection = DriverManager.getConnection(sqlUrl, sqlUrlUsername, sqlUrlpassword);

			// empowering the connection reference variable to execute queries
			statement = connection.createStatement();

			// delivering the query
			resultSet = statement.executeQuery(sqlquery);

			while (resultSet.next()) {
				columnValue = resultSet.getString(columName);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return columnValue;

	}

}
