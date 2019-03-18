package br.com.caelum.jdbc;

import java.sql.*;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			//                                     url do banco           user       senha
			return DriverManager.getConnection("jdbc:postgresql:fj21", "eclipse", "407186");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
