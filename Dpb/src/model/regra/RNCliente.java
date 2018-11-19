package model.regra;

import java.util.ArrayList;

import model.classesbasicas.Cliente;
import model.dao.DAOCliente;
import model.dao.DAOClienteImpl;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;
import model.excecoes.RegraException;

public class RNCliente {

	private final DAOCliente dao = new DAOClienteImpl();

	public void incluir(Cliente cliente) throws RegraException {

		try {

			dao.incluir(cliente);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void alterar(Cliente cliente) throws RegraException {

		try {

			dao.alterar(cliente);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void excluir(Cliente cliente) throws RegraException {

		try {

			dao.excluir(cliente);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Cliente pesquisar(Integer id) throws RegraException {

		try {

			return dao.pesquisar(id);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Cliente pesquisar(String cnpj) throws RegraException {

		try {

			return dao.pesquisar(cnpj);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public ArrayList<Cliente> listar() throws RegraException {

		try {

			return dao.listar();

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public boolean validarRazaoSocial(Cliente cliente) {

		return cliente.getRazaoSocial().trim().length() > 40;

	}

	public boolean validarNomeFantasia(Cliente cliente) {

		return cliente.getNomeFantasia().trim().length() > 20;

	}

	public boolean validarCnpj(Cliente cliente) {

		return cliente.getCnpj().trim().length() != 14;

	}

	public boolean validarEmail(Cliente cliente) {

		return cliente.getEmail().trim().length() > 50;

	}

	public void validacaoBasica(Cliente cliente) throws RegraException {

		if ((cliente.getCnpj() == null) || (cliente.getCnpj().trim().equals("") || (cliente.getCnpj().isEmpty()))) {

			throw new RegraException("Cnpj inválido!");

		}

		if ((cliente.getNomeFantasia() == null)
				|| (cliente.getNomeFantasia().trim().equals("") || (cliente.getNomeFantasia().isEmpty()))) {

			throw new RegraException("Nome fantasia inválido!");

		}

		if ((cliente.getRazaoSocial() == null)
				|| (cliente.getRazaoSocial().trim().equals("") || (cliente.getRazaoSocial().isEmpty()))) {

			throw new RegraException("Razão social inválido!");

		}

		if ((cliente.getLogradouro() == null)
				|| (cliente.getLogradouro().trim().equals("") || (cliente.getLogradouro().isEmpty()))) {

			throw new RegraException("Logradouro inválido!");

		}

		if ((cliente.getNumero() == null)
				|| (cliente.getNumero().trim().equals("") || (cliente.getNumero().isEmpty()))) {

			throw new RegraException("Número inválido!");

		}

		if ((cliente.getBairro() == null)
				|| (cliente.getBairro().trim().equals("") || (cliente.getBairro().isEmpty()))) {

			throw new RegraException("Bairro inválido!");

		}

		if ((cliente.getCidade() == null)
				|| (cliente.getCidade().trim().equals("") || (cliente.getCidade().isEmpty()))) {

			throw new RegraException("Cidade inválido!");

		}

		if ((cliente.getEstado() == null)
				|| (cliente.getEstado().trim().equals("") || (cliente.getEstado().isEmpty()))) {

			throw new RegraException("Estado inválido!");

		}

		if ((cliente.getEmail() == null) || (cliente.getEmail().trim().equals("") || (cliente.getEmail().isEmpty()))) {

			throw new RegraException("E-mail inválido!");

		}
	}

	public Cliente verificaDuplicidade(Cliente cliente) throws RegraException {

		try {

			Cliente x = dao.pesquisar(cliente.getCnpj());

			if (x != null) {

				throw new RegraException("Cliente já existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}

		return cliente;

	}

	public void validaIdNull(Integer id) throws RegraException {

		if (id == null) {

			throw new RegraException("Id inválido!");

		}
	}

	public void validaIdExistente(Integer id) throws RegraException {

		try {

			Cliente x = dao.pesquisar(id);

			if (x != null) {

				throw new RegraException("Id informado existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}
}
