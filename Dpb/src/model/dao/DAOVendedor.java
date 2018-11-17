package model.dao;

import java.util.ArrayList;

import model.classesbasicas.Vendedor;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public interface DAOVendedor {

	public void incluir(Vendedor vendedor) throws ConexaoException, DAOException;

	public void alterar(Vendedor vendedor) throws ConexaoException, DAOException;

	public void excluir(Vendedor vendedor) throws ConexaoException, DAOException;

	public Vendedor pesquisar(Integer id) throws ConexaoException, DAOException;

	public Vendedor pesquisar(String cpf) throws ConexaoException, DAOException;

	public ArrayList<Vendedor> listar() throws ConexaoException, DAOException;

}
