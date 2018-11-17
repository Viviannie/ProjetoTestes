package model.conexao;

import java.sql.Connection;

import model.excecoes.ConexaoException;

public interface ConnectionBD {
	
	public Connection getConexao() throws ConexaoException;

	public void desconectar(Connection c) throws ConexaoException;

}
