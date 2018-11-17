package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.excecoes.ConexaoException;

public class ConnectionFactory implements ConnectionBD {

	private static ConnectionFactory instancia;

	public static ConnectionFactory getInstancia() {

		if (instancia == null) {

			instancia = new ConnectionFactory();

		}

		return instancia;

	}

	public Connection getConexao() throws ConexaoException {

		Connection conexao = null;

		if(conexao == null) {

			try {

				final String URL = "jdbc:mysql://localhost:3306/dpb?autoReconnect=true&useSSL=false";
				final String driver = "com.mysql.jdbc.Driver";
				final String USER = "root";
				final String PASS = "root";				

				Class.forName(driver);
				conexao = DriverManager.getConnection(URL, USER, PASS);

			} catch (SQLException ex) {

				throw new ConexaoException("Não foi possível conectar ao banco de dados!", ex);


			} catch (ClassNotFoundException ex) {

				throw new ConexaoException("O driver do banco de dados não foi encontrado!", ex);

			}
		}

		return conexao;

	}

	public void desconectar(Connection c) throws ConexaoException {

		try {

			c.close(); 

		} catch (SQLException ex) {

			throw new ConexaoException("Erro ao fechar conexão com o Banco de Dados!", ex);

		}
	}
}