package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.classesbasicas.Cliente;
import model.conexao.ConnectionBD;
import model.conexao.ConnectionFactory;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;

import java.sql.Connection;

public class DAOClienteImpl implements DAOCliente {

	private ConnectionBD con;

	public DAOClienteImpl() {

		con = ConnectionFactory.getInstancia();

	}

	@Override
	public void incluir(Cliente cliente) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "INSERT INTO vendedor (razao_social, nome_fantasia, cnpj, logradouro, numero, bairro, cidade, estado, email) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cliente.getRazaoSocial());
			pstm.setString(2, cliente.getNomeFantasia());
			pstm.setString(3, cliente.getCnpj());
			pstm.setString(4, cliente.getLogradouro());
			pstm.setString(5, cliente.getNumero());
			pstm.setString(6, cliente.getBairro());
			pstm.setString(7, cliente.getCidade());
			pstm.setString(8, cliente.getEstado());
			pstm.setString(9, cliente.getEmail());
			pstm.executeUpdate();
			pstm.close();
			
		} catch (SQLException e) {
			
			throw new DAOException(e);
			
		}
	}
	
	@Override
	public void alterar(Cliente cliente) throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "UPDATE vendedor SET (razao_social=?, nome_fantasia=?, cnpj=?, logradouro=?, numero=?, bairro=?, cidade=?, estado=?, email=?) WHERE (id=?)";
		 
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cliente.getRazaoSocial());
			pstm.setString(2, cliente.getNomeFantasia());
			pstm.setString(3, cliente.getCnpj());
			pstm.setString(4, cliente.getLogradouro());
			pstm.setString(5, cliente.getNumero());
			pstm.setString(6, cliente.getBairro());
			pstm.setString(7, cliente.getCidade());
			pstm.setString(8, cliente.getEstado());
			pstm.setString(9, cliente.getEmail());
			pstm.setInt(10, cliente.getId());
			pstm.executeUpdate();
			pstm.close();
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}

	@Override
	public void excluir(Cliente cliente) throws ConexaoException, DAOException {
		
		Connection c = con.getConexao();
		
		String sql = "DELETE FROM vendedor WHERE (id=?)";
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, cliente.getId());
			pstm.executeUpdate();
			pstm.close();
			
		} catch (SQLException e) {
			
			throw new DAOException(e);
			
		}
	}

	@Override
	public Cliente pesquisar(Integer id) throws ConexaoException, DAOException {
				
		Connection c = con.getConexao();
		
		String sql = "SELECT id, razao_social, nome_fantasia, cnpj, logradouro, numero, bairro, cidade, estado, email FROM vendedor WHERE (id=?)";
		
		Cliente cliente = null;
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()){
				
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setRazaoSocial(rs.getString("razao_social"));
				cliente.setNomeFantasia(rs.getString("nome_fantasia"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setEmail(rs.getString("email"));
				
			}
			
			return cliente;
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}

	@Override
	public Cliente pesquisar(String cnpj) throws ConexaoException, DAOException {
		
		Connection c = con.getConexao();
		
		String sql = "SELECT id, razao_social, nome_fantasia, cnpj, logradouro, numero, bairro, cidade, estado, email FROM vendedor WHERE (cnpj=?)";
		
		Cliente cliente = null;
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cnpj);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setRazaoSocial(rs.getString("razao_social"));
				cliente.setNomeFantasia(rs.getString("nome_fantasia"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setEmail(rs.getString("email"));
				
			}
			
			return cliente;
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}

	@Override
	public ArrayList<Cliente> listar() throws ConexaoException, DAOException {

		Connection c = con.getConexao();
		
		String sql = "SELECT id, razao_social, nome_fantasia, cnpj, logradouro, numero, bairro, cidade, estado, email FROM vendedor";
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		Cliente cliente;
		
		try {
			
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setRazaoSocial(rs.getString("razao_social"));
				cliente.setNomeFantasia(rs.getString("nome_fantasia"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setEmail(rs.getString("email"));
				lista.add(cliente);
				
			}
			
			return lista;
			
		} catch(SQLException e) {
			
			throw new DAOException(e);
			
		}
	}
}
