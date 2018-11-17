package model.regra;

import java.util.ArrayList;

import model.classesbasicas.Pedido;
import model.dao.DAOPedido;
import model.dao.DAOPedidoImpl;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;
import model.excecoes.RegraException;

public class RNPedido {

	private final DAOPedido dao = new DAOPedidoImpl();

	public void incluir(Pedido pedido) throws RegraException {

		try {

			dao.incluir(pedido);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void alterar(Pedido pedido) throws RegraException {

		try {

			dao.alterar(pedido);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void excluir(Pedido pedido) throws RegraException {

		try {

			dao.excluir(pedido);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Pedido pesquisar(Integer id) throws RegraException {

		try {

			return dao.pesquisar(id);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public ArrayList<Pedido> listar() throws RegraException {

		try {

			return dao.listar();

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void validarCampos(Pedido pedido) throws RegraException {

		if (pedido.getCliente() == null) {

			throw new RegraException("Cliente inválido!");

		}

		if (pedido.getVendedor() == null) {

			throw new RegraException("Vendedor inválido!");

		}

		if (pedido.getStatusPedido() == null) {

			throw new RegraException("Status do pedido inválido!");

		}
	}

	public Pedido verificaDuplicidade(Pedido pedido) throws RegraException {

		try {

			Pedido x = dao.pesquisar(pedido.getId());

			if (x != null) {

				throw new RegraException("Pedido já existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}

		return pedido;

	}

	public void validaIdNull(Integer id) throws RegraException {

		if (id == null) {

			throw new RegraException("Id inválido!");

		}
	}

	public void validaIdExistente(Integer id) throws RegraException {

		try {

			Pedido x = dao.pesquisar(id);

			if (x != null) {

				throw new RegraException("Id informado existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}
}
