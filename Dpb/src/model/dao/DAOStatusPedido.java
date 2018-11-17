package model.dao;

import java.util.ArrayList;

import model.classesbasicas.StatusPedido;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public interface DAOStatusPedido {

	public void incluir(StatusPedido statusPedido) throws ConexaoException, DAOException;

	public void alterar(StatusPedido statusPedido) throws ConexaoException, DAOException;

	public void excluir(StatusPedido statusPedido) throws ConexaoException, DAOException;

	public StatusPedido pesquisar(Integer id) throws ConexaoException, DAOException;

	public StatusPedido pesquisar(String descricao) throws ConexaoException, DAOException;

	public ArrayList<StatusPedido> listar() throws ConexaoException, DAOException;

}
