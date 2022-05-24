package br.com.fiap.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	public Connection conectarOracle() {

		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "usuario", "senha");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			throw new RuntimeException(e);
		}
	}
}
