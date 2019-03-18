package br.com.caelum.jdbc;

import java.sql.*;

/**
 * @author adaao
 *
 */
public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexao aberta!");
		connection.close();
		System.out.println("***** Conexao fechada!!!! *****");
	}

}
