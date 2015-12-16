package br.com.lucasburg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Adapter {
	public static Connection criar()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String stringConexao = "jdbc:mysql://127.0.0.1/cursojavabasico?useSSL=false&user=root&password=96342292";
		return DriverManager.getConnection(stringConexao);
	}
}
