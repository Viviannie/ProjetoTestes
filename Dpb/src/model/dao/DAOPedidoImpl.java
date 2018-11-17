package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.classesbasicas.Pedido;
import model.conexao.ConnectionBD;
import model.conexao.ConnectionFactory;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public class DAOPedidoImpl implements DAOPedido {

	private ConnectionBD con;

	public DAOPedidoImpl() {

		con = ConnectionFactory.getInstancia();

	}

	@Override
	public void incluir(Pedido pedido) throws ConexaoException, DAOException {
		
		Connection c = con.getConexao();
		
		String sql = "INSERT INTO pedido (id_cliente, id_vendedor, id_status_pedido, data_pedido, data_envio) VALUES (?,?,?,?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, pedido.getCliente().getId());
			pstm.setInt(2, pedido.getVendedor().getId());
			pstm.setInt(3, pedido.getStatusPedido().getId());
			pstm.setDate(4, pedido.getDataEnvio());
			pstm.setDate(5, pedido.getDataPedido());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException(e);

		}
	}
	
	@Override
	public void alterar(Pedido pedido) throws ConexaoException, DAOException {
		
		Connection c = con.getConexao();
		
		String sql = "UPDATE pedido SET (id_cliente=?, id_vendedor=?, id_status_pedido=?, data_pedido=?, data_envio=?) WHERE (id=?)";
		 
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, pedido.getCliente().getId());
			pstm.setInt(2, pedido.getVendedor().getId());
			pstm.setInt(3, pedido.getStatusPedido().getId());
			pstm.setDate(4, pedido.getDataEnvio());
			pstm.setDate(5, pedido.getDataPedido());
			pstm.setInt(6, pedido.getId());
			pstm.executeUpdate();
			pstm.close();
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}

	@Override
	public void excluir(Pedido pedido) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "DELETE FROM pedido WHERE (id=?)";
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, pedido.getId());
			pstm.executeUpdate();
			pstm.close();
			
		} catch (SQLException e) {
			
			throw new DAOException(e);
			
		}
	}

	@Override
	public Pedido pesquisar(Integer id) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, id_cliente, id_vendedor, id_status_pedido, data_pedido, data_envio FROM pedido WHERE (id=?)";
		
		Pedido pedido = null;
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()){
				
				pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.getCliente().setId(rs.getInt("id_cliente"));
				pedido.getVendedor().setId(rs.getInt("id_vendedor"));
				pedido.getStatusPedido().setId(rs.getInt("id_status_pedido"));
				pedido.setDataPedido(rs.getDate("data_pedido"));
				pedido.setDataEnvio(rs.getDate("data_envio"));
				
			}
			
			return pedido;
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}

	@Override
	public ArrayList<Pedido> listar() throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, id_cliente, id_vendedor, id_status_pedido, data_pedido, data_envio FROM pedido";
		
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		Pedido pedido;
		
		try {
			
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.getCliente().setId(rs.getInt("id_cliente"));
				pedido.getVendedor().setId(rs.getInt("id_vendedor"));
				pedido.getStatusPedido().setId(rs.getInt("id_status_pedido"));
				pedido.setDataPedido(rs.getDate("data_pedido"));
				pedido.setDataEnvio(rs.getDate("data_envio"));
				lista.add(pedido);
				
			}
			
			return lista;
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}
}
