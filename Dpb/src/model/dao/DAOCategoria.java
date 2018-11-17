package model.dao;

import java.util.ArrayList;

import model.classesbasicas.Categoria;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public interface DAOCategoria {

	public void incluir(Categoria categoria) throws ConexaoException, DAOException;

	public void alterar(Categoria categoria) throws ConexaoException, DAOException;

	public void excluir(Categoria categoria) throws ConexaoException, DAOException;

	public Categoria pesquisar(Integer id) throws ConexaoException, DAOException;

	public Categoria pesquisar(String descricao) throws ConexaoException, DAOException;

	public ArrayList<Categoria> listar() throws ConexaoException, DAOException; 

}
