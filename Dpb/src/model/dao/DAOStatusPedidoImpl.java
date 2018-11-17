package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.classesbasicas.StatusPedido;
import model.conexao.ConnectionBD;
import model.conexao.ConnectionFactory;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public class DAOStatusPedidoImpl implements DAOStatusPedido {

	private ConnectionBD con;

	public DAOStatusPedidoImpl() {

		con = ConnectionFactory.getInstancia();

	}

	@Override
	public void incluir(StatusPedido statusPedido) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "INSERT INTO status_pedido (descricao) VALUES (?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, statusPedido.getDescricao());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public void alterar(StatusPedido statusPedido) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "UPDATE status_pedido SET (descricao=?) WHERE (id=?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, statusPedido.getDescricao());
			pstm.setInt(2, statusPedido.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public void excluir(StatusPedido statusPedido) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "DELETE FROM status_pedido WHERE (id=?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, statusPedido.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public StatusPedido pesquisar(Integer id) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, descricao FROM status_pedido WHERE (id=?)";

		StatusPedido statusPedido = null;

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();

			if(rs.next()){

				statusPedido = new StatusPedido();
				statusPedido.setId(rs.getInt("id"));
				statusPedido.setDescricao(rs.getString("razao_social"));

			}

			return statusPedido;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public StatusPedido pesquisar(String descricao) throws ConexaoException, DAOException {

		Connection c = con.getConexao();

		String sql = "SELECT id, descricao FROM status_pedido WHERE (descricao=?)";

		StatusPedido statusPedido = null;

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, descricao);
			ResultSet rs = pstm.executeQuery();

			if(rs.next()) {

				statusPedido = new StatusPedido();
				statusPedido.setId(rs.getInt("id"));
				statusPedido.setDescricao(rs.getString("descricao"));

			}

			return statusPedido;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public ArrayList<StatusPedido> listar() throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, descricao FROM status_pedido";

		ArrayList<StatusPedido> lista = new ArrayList<StatusPedido>();

		StatusPedido statusPedido;

		try {

			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {

				statusPedido = new StatusPedido();
				statusPedido.setId(rs.getInt("id"));
				statusPedido.setDescricao(rs.getString("descricao"));
				lista.add(statusPedido);

			}

			return lista;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}
}
