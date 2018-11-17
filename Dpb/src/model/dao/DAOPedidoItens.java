package model.dao;

import java.util.ArrayList;

import model.classesbasicas.PedidoItens;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public interface DAOPedidoItens {

	public void incluir(PedidoItens pedidoItens) throws ConexaoException, DAOException;

	public void alterar(PedidoItens pedidoItens) throws ConexaoException, DAOException;

	public void excluir(PedidoItens pedidoItens) throws ConexaoException, DAOException;

	public PedidoItens pesquisar(Integer id) throws ConexaoException, DAOException;

	public ArrayList<PedidoItens> listar() throws ConexaoException, DAOException; 

}
