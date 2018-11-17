package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.classesbasicas.Vendedor;
import model.conexao.ConnectionBD;
import model.conexao.ConnectionFactory;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

public class DAOVendedorImpl implements DAOVendedor {

	private ConnectionBD con;

	public DAOVendedorImpl() {

		con = ConnectionFactory.getInstancia();

	}

	@Override
	public void incluir(Vendedor vendedor) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "INSERT INTO vendedor (nome, cpf, email, senha, logradouro, numero, bairro, cidade, estado, ativo) VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, vendedor.getNome());
			pstm.setString(2, vendedor.getCpf());
			pstm.setString(3, vendedor.getEmail());
			pstm.setString(4, vendedor.getSenha());
			pstm.setString(5, vendedor.getLogradouro());
			pstm.setString(6, vendedor.getNumero());
			pstm.setString(7, vendedor.getBairro());
			pstm.setString(8, vendedor.getCidade());
			pstm.setString(9, vendedor.getEstado());
			pstm.setString(10, String.valueOf(vendedor.getAtivo()));
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public void alterar(Vendedor vendedor) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "UPDATE vendedor SET (nome=?, cpf=?, email=?, senha=?, logradouro=?, numero=?, bairro=?, cidade=?, estado=?, ativo=?) WHERE (id=?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, vendedor.getNome());
			pstm.setString(2, vendedor.getCpf());
			pstm.setString(3, vendedor.getEmail());
			pstm.setString(4, vendedor.getSenha());
			pstm.setString(5, vendedor.getLogradouro());
			pstm.setString(6, vendedor.getNumero());
			pstm.setString(7, vendedor.getBairro());
			pstm.setString(8, vendedor.getCidade());
			pstm.setString(9, vendedor.getEstado());
			pstm.setString(10, String.valueOf(vendedor.getAtivo()));
			pstm.setInt(11, vendedor.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public void excluir(Vendedor vendedor) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "DELETE FROM vendedor WHERE (id=?)";

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, vendedor.getId());
			pstm.executeUpdate();
			pstm.close();

		} catch (SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public Vendedor pesquisar(Integer id) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, nome, cpf, email, senha, logradouro, numero, bairro, cidade, estado, ativo FROM vendedor WHERE (id=?)";

		Vendedor vendedor = null;

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();

			if(rs.next()){

				vendedor = new Vendedor();
				vendedor.setId(rs.getInt("id"));
				vendedor.setNome(rs.getString("nome"));
				vendedor.setCpf(rs.getString("cpf"));
				vendedor.setEmail(rs.getString("email"));
				vendedor.setSenha(rs.getString("senha"));
				vendedor.setLogradouro(rs.getString("logradouro"));
				vendedor.setNumero(rs.getString("numero"));
				vendedor.setBairro(rs.getString("bairro"));
				vendedor.setCidade(rs.getString("cidade"));
				vendedor.setEstado(rs.getString("estado"));
				vendedor.setAtivo(rs.getString("ativo").charAt(0));

			}

			return vendedor;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public Vendedor pesquisar(String cpf) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, nome, cpf, email, senha, logradouro, numero, bairro, cidade, estado, ativo FROM vendedor WHERE (cpf=?)";

		Vendedor vendedor = null;

		try {

			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cpf);
			ResultSet rs = pstm.executeQuery();

			if(rs.next()) {

				vendedor = new Vendedor();
				vendedor.setId(rs.getInt("id"));
				vendedor.setNome(rs.getString("nome"));
				vendedor.setCpf(rs.getString("cpf"));
				vendedor.setEmail(rs.getString("email"));
				vendedor.setSenha(rs.getString("senha"));
				vendedor.setLogradouro(rs.getString("logradouro"));
				vendedor.setNumero(rs.getString("numero"));
				vendedor.setBairro(rs.getString("bairro"));
				vendedor.setCidade(rs.getString("cidade"));
				vendedor.setEstado(rs.getString("estado"));
				vendedor.setAtivo(rs.getString("ativo").charAt(0));

			}

			return vendedor;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}

	@Override
	public ArrayList<Vendedor> listar() throws ConexaoException, DAOException {
		
		Connection c = con.getConexao();
		
		String sql = "SELECT id, nome, cpf, email, senha, logradouro, numero, bairro, cidade, estado, ativo FROM vendedor";

		ArrayList<Vendedor> lista = new ArrayList<Vendedor>();
		
		Vendedor vendedor;

		try {

			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {

				vendedor = new Vendedor();
				vendedor.setId(rs.getInt("id"));
				vendedor.setNome(rs.getString("nome"));
				vendedor.setCpf(rs.getString("cpf"));
				vendedor.setEmail(rs.getString("email"));
				vendedor.setSenha(rs.getString("senha"));
				vendedor.setLogradouro(rs.getString("logradouro"));
				vendedor.setNumero(rs.getString("numero"));
				vendedor.setBairro(rs.getString("bairro"));
				vendedor.setCidade(rs.getString("cidade"));
				vendedor.setEstado(rs.getString("estado"));
				vendedor.setAtivo(rs.getString("ativo").charAt(0));
				lista.add(vendedor);

			}

			return lista;

		} catch(SQLException e) {

			throw new DAOException(e);

		}
	}
}
