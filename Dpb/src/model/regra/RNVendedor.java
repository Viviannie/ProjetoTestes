package model.regra;

import java.util.ArrayList;

import model.classesbasicas.Vendedor;
import model.dao.DAOVendedor;
import model.dao.DAOVendedorImpl;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;
import model.excecoes.RegraException;

public class RNVendedor {

	private final DAOVendedor dao = new DAOVendedorImpl();

	public void incluir(Vendedor vendedor) throws RegraException {

		try {

			dao.incluir(vendedor);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void alterar(Vendedor vendedor) throws RegraException {

		try {

			dao.alterar(vendedor);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void excluir(Vendedor vendedor) throws RegraException {

		try {

			dao.excluir(vendedor);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Vendedor pesquisar(Integer id) throws RegraException {

		try {

			return dao.pesquisar(id);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Vendedor pesquisar(String cpf) throws RegraException {

		try {

			return dao.pesquisar(cpf);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public ArrayList<Vendedor> listar() throws RegraException {

		try {

			return dao.listar();

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void validarCampos(Vendedor vendedor) throws RegraException {

		if ((vendedor.getNome() == null) || (vendedor.getNome().trim().equals("")) || (vendedor.getNome().isEmpty())) {

			throw new RegraException("Nome inválido!");

		}

		if ((vendedor.getCpf() == null) || (vendedor.getCpf().trim().equals("")) || (vendedor.getCpf().isEmpty())) {

			throw new RegraException("Cpf inválido!");

		}

		if ((vendedor.getEmail() == null) || (vendedor.getEmail().trim().equals(""))
				|| (vendedor.getEmail().isEmpty())) {

			throw new RegraException("E-mail inválido!");

		}

		if ((vendedor.getSenha() == null) || (vendedor.getSenha().trim().equals(""))
				|| (vendedor.getSenha().isEmpty())) {

			throw new RegraException("Senha inválida!");

		}

		if ((vendedor.getLogradouro() == null)
				|| (vendedor.getLogradouro().trim().equals("") || (vendedor.getLogradouro().isEmpty()))) {

			throw new RegraException("Logradouro inválido!");

		}

		if ((vendedor.getNumero() == null)
				|| (vendedor.getNumero().trim().equals("") || (vendedor.getNumero().isEmpty()))) {

			throw new RegraException("Número inválido!");

		}

		if ((vendedor.getBairro() == null)
				|| (vendedor.getBairro().trim().equals("") || (vendedor.getBairro().isEmpty()))) {

			throw new RegraException("Bairro inválido!");

		}

		if ((vendedor.getCidade() == null)
				|| (vendedor.getCidade().trim().equals("") || (vendedor.getCidade().isEmpty()))) {

			throw new RegraException("Cidade inválido!");

		}

		if ((vendedor.getEstado() == null)
				|| (vendedor.getEstado().trim().equals("") || (vendedor.getEstado().isEmpty()))) {

			throw new RegraException("Estado inválido!");

		}
	}

	public boolean validarNome(Vendedor vendedor) throws RegraException {

		return vendedor.getNome().length() > 50;

	}

	public boolean validarCpf(Vendedor vendedor) throws RegraException {

		return vendedor.getCpf().length() > 11;

	}

	public boolean validarEmail(Vendedor vendedor) throws RegraException {

		return vendedor.getEmail().length() > 50;

	}

	public boolean validarSenha(Vendedor vendedor) throws RegraException {

		return vendedor.getSenha().length() > 32;

	}

	public Vendedor verificaDuplicidade(Vendedor vendedor) throws RegraException {

		try {

			Vendedor x = dao.pesquisar(vendedor.getId());

			if (x != null) {

				throw new RegraException("Vendedor já existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}

		return vendedor;

	}

	public void validaIdNull(Integer id) throws RegraException {

		if (id == null) {

			throw new RegraException("Id inválido!");

		}
	}

	public void validaIdExistente(Integer id) throws RegraException {

		try {

			Vendedor x = dao.pesquisar(id);

			if (x != null) {

				throw new RegraException("Id informado existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}
}
