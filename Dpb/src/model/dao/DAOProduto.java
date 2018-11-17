package model.dao;

import java.util.ArrayList;

import model.classesbasicas.Produto;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public interface DAOProduto {

	public void incluir(Produto produto) throws ConexaoException, DAOException;

	public void alterar(Produto produto) throws ConexaoException, DAOException;

	public void excluir(Produto produto) throws ConexaoException, DAOException;

	public Produto pesquisar(Integer id) throws ConexaoException, DAOException;

	public Produto pesquisar(String descricao) throws ConexaoException, DAOException;

	public ArrayList<Produto> listar() throws ConexaoException, DAOException;

}
