package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.classesbasicas.Produto;
import model.conexao.ConnectionBD;
import model.conexao.ConnectionFactory;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public class DAOProdutoImpl implements DAOProduto {

	private ConnectionBD con;

	public DAOProdutoImpl() {

		con = ConnectionFactory.getInstancia();

	}

	@Override
	public void incluir(Produto produto) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "INSERT INTO produto (descricao, preco_unitario, id_categoria, ativo) VALUES (?,?,?,?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, produto.getDescricao());
			pstm.setDouble(2, produto.getPrecoUnitario());
			pstm.setInt(3, produto.getCategoria().getId());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public void alterar(Produto produto) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "UPDATE produto SET (descricao=?, preco_unitario=?, id_categoria=?, ativo=?) WHERE (id=?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, produto.getDescricao());
			pstm.setDouble(2, produto.getPrecoUnitario());
			pstm.setInt(3, produto.getCategoria().getId());
			pstm.setString(4, String.valueOf(produto.getAtivo()));
			pstm.setInt(5, produto.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public void excluir(Produto produto) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "DELETE FROM produto WHERE (id=?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, produto.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public Produto pesquisar(Integer id) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, descricao, preco_unitario, id_categoria, ativo FROM produto WHERE (id=?)";

		Produto produto = null;

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();

			if(rs.next()){

				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPrecoUnitario(rs.getDouble("preco_unitario"));
				produto.getCategoria().setId(rs.getInt("id_categoria"));
				produto.setAtivo(rs.getString("ativo").charAt(0));

			}

			return produto;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public Produto pesquisar(String descricao) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, descricao, preco_unitario, id_categoria, ativo FROM produto WHERE (descricao=?)";

		Produto produto = null;

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, descricao);
			ResultSet rs = pstm.executeQuery();

			if(rs.next()) {

				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPrecoUnitario(rs.getDouble("preco_unitario"));
				produto.getCategoria().setId(rs.getInt("id_categoria"));
				produto.setAtivo(rs.getString("ativo").charAt(0));

			}

			return produto;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public ArrayList<Produto> listar() throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, descricao, preco_unitario, id_categoria, ativo FROM produto";

		ArrayList<Produto> lista = new ArrayList<Produto>();
		Produto produto;

		try {

			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {

				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPrecoUnitario(rs.getDouble("preco_unitario"));
				produto.getCategoria().setId(rs.getInt("id_categoria"));
				produto.setAtivo(rs.getString("ativo").charAt(0));
				lista.add(produto);

			}

			return lista;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}
}
