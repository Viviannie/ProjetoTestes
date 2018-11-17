package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.classesbasicas.PedidoItens;
import model.conexao.ConnectionBD;
import model.conexao.ConnectionFactory;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public class DAOPedidoItensImpl implements DAOPedidoItens {

	private ConnectionBD con;

	public DAOPedidoItensImpl() {

		con = ConnectionFactory.getInstancia();

	}

	@Override
	public void incluir(PedidoItens pedidoItens) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "INSERT INTO pedido_itens (id_pedido, id_produto, quantidade, preco_unitario) VALUES (?,?,?,?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, pedidoItens.getPedido().getId());
			pstm.setInt(2, pedidoItens.getProduto().getId());
			pstm.setInt(3, pedidoItens.getQuantidade());
			pstm.setDouble(4, pedidoItens.getPrecoUnitario());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException(e);

		}	}

	@Override
	public void alterar(PedidoItens pedidoItens) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "UPDATE pedido_itens SET (id_pedido=?, id_produto=?, quantidade=?, preco_unitario=?) WHERE (id=?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, pedidoItens.getPedido().getId());
			pstm.setInt(2, pedidoItens.getProduto().getId());
			pstm.setInt(3, pedidoItens.getQuantidade());
			pstm.setDouble(4, pedidoItens.getPrecoUnitario());
			pstm.setInt(5, pedidoItens.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch(SQLException e) {

			throw new DAOException(e);

		}	}

	@Override
	public void excluir(PedidoItens pedidoItens) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "DELETE FROM pedido_itens WHERE (id=?)";
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, pedidoItens.getId());
			pstm.executeUpdate();
			pstm.close();
			
		} catch (SQLException e) {
			
			throw new DAOException(e);
			
		}

	}

	@Override
	public PedidoItens pesquisar(Integer id) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, id_pedido, id_produto, quantidade, preco_unitario FROM pedido_itens WHERE (id=?)";
		
		PedidoItens pedidoItens = null;
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()){
				
				pedidoItens = new PedidoItens();
				pedidoItens.setId(rs.getInt("id"));
				pedidoItens.getPedido().setId(rs.getInt("id_pedido"));
				pedidoItens.getProduto().setId(rs.getInt("id_produto"));
				pedidoItens.setQuantidade(rs.getInt("quantidade"));
				pedidoItens.setPrecoUnitario(rs.getDouble("preco_unitario"));
				
			}
			
			return pedidoItens;
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}

	@Override
	public ArrayList<PedidoItens> listar() throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, id_cliente, id_vendedor, data_pedido, data_envio FROM pedido_itens";
		
		ArrayList<PedidoItens> lista = new ArrayList<PedidoItens>();
		PedidoItens pedidoItens;
		
		try {
			
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				pedidoItens = new PedidoItens();
				pedidoItens.setId(rs.getInt("id"));
				pedidoItens.getPedido().setId(rs.getInt("id_pedido"));
				pedidoItens.getProduto().setId(rs.getInt("id_produto"));
				pedidoItens.setQuantidade(rs.getInt("quantidade"));
				pedidoItens.setPrecoUnitario(rs.getDouble("preco_unitario"));
				lista.add(pedidoItens);
				
			}
			
			return lista;
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}
}
