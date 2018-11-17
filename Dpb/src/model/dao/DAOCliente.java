package model.dao;

import java.util.ArrayList;

import model.classesbasicas.Cliente;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public interface DAOCliente {

	public void incluir(Cliente cliente) throws ConexaoException, DAOException;

	public void alterar(Cliente cliente) throws ConexaoException, DAOException;

	public void excluir(Cliente cliente) throws ConexaoException, DAOException;

	public Cliente pesquisar(Integer id) throws ConexaoException, DAOException;

	public Cliente pesquisar(String cnpj) throws ConexaoException, DAOException;

	public ArrayList<Cliente> listar() throws ConexaoException, DAOException;

}
