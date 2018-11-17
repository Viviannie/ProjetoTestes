package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.classesbasicas.Categoria;
import model.conexao.ConnectionBD;
import model.conexao.ConnectionFactory;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public class DAOCategoriaImpl implements DAOCategoria {

	private ConnectionBD con;

	public DAOCategoriaImpl() {

		con = ConnectionFactory.getInstancia();

	}

	@Override
	public void incluir(Categoria categoria) throws ConexaoException, DAOException {

		Connection c = con.getConexao();

		String sql = "INSERT INTO categoria (descricao) VALUES (?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, categoria.getDescricao());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException("Erro ao inserir categoria!", e);

		} finally {        

			con.desconectar(c);

		}		
	}

	@Override
	public void alterar(Categoria categoria) throws ConexaoException, DAOException {

		Connection c = con.getConexao();

		String sql = "UPDATE categoria SET id = ?, descricao = ? WHERE id = ?";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, categoria.getId());
			pstm.setString(2, categoria.getDescricao());
			pstm.setInt(3, categoria.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException("Erro ao alterar categoria!", e);

		} finally {        

			con.desconectar(c);

		}		
	}

	@Override
	public void excluir(Categoria categoria) throws ConexaoException, DAOException {

		Connection c = con.getConexao();

		String sql = "DELETE FROM categoria WHERE (id=?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, categoria.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException("Erro ao excluir categoria!", e);

		} finally {        

			con.desconectar(c);

		}		
	}	

	@Override
	public Categoria pesquisar(Integer id) throws ConexaoException, DAOException {

		Connection c = con.getConexao();

		String sql = "SELECT id, descricao FROM categoria WHERE (id=?)";

		Categoria categoria = null;

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();

			if(rs.next()){

				categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setDescricao(rs.getString("descricao"));

			}

			return categoria;

		} catch (SQLException e) {

			throw new DAOException("Erro ao pesquisar categoria por id!", e);

		} finally {        

			con.desconectar(c);

		}		
	}

	@Override
	public Categoria pesquisar(String descricao) throws ConexaoException, DAOException {

		Connection c = con.getConexao();

		String sql = "SELECT id, descricao FROM categoria WHERE (descricao=?)";

		Categoria categoria = null;

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, descricao);
			ResultSet rs = pstm.executeQuery();

			if(rs.next()){

				categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setDescricao(rs.getString("descricao"));

			}

			return categoria;

		} catch (SQLException e) {

			throw new DAOException("Erro ao pesquisar categoria por descrição!", e);

		} finally {        

			con.desconectar(c);

		}			
	}

	@Override
	public ArrayList<Categoria> listar() throws ConexaoException, DAOException {

		Connection c = con.getConexao();

		String sql = "SELECT id, descricao FROM categoria";

		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		Categoria categoria;

		try {

			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {

				categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setDescricao(rs.getString("descricao"));
				lista.add(categoria);

			}

			return lista;

		} catch (SQLException e) {

			throw new DAOException("Erro ao listar categoria!", e);

		} finally {        

			con.desconectar(c);

		}		
	}
}
