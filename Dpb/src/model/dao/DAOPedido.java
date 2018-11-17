package model.dao;

import java.util.ArrayList;

import model.classesbasicas.Pedido;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public interface DAOPedido {
	
	public void incluir(Pedido pedido) throws ConexaoException, DAOException;
    
    public void alterar(Pedido pedido) throws ConexaoException, DAOException;
    
    public void excluir(Pedido pedido) throws ConexaoException, DAOException;
    
    public Pedido pesquisar(Integer id) throws ConexaoException, DAOException;
    
    public ArrayList<Pedido> listar() throws ConexaoException, DAOException; 

}
