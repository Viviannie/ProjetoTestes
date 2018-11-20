package model.regra;

import java.util.ArrayList;

import model.classesbasicas.PedidoItens;
import model.dao.DAOPedidoItens;
import model.dao.DAOPedidoItensImpl;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;
import model.excecoes.RegraException;

public class RNPedidoItens {

	private final DAOPedidoItens dao = new DAOPedidoItensImpl();

	public void incluir(PedidoItens pedidoItens) throws RegraException {

		try {

			dao.incluir(pedidoItens);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void alterar(PedidoItens pedidoItens) throws RegraException {

		try {

			dao.alterar(pedidoItens);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void excluir(PedidoItens pedidoItens) throws RegraException {

		try {

			dao.excluir(pedidoItens);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public PedidoItens pesquisar(Integer id) throws RegraException {

		try {

			return dao.pesquisar(id);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public ArrayList<PedidoItens> listar() throws RegraException {

		try {

			return dao.listar();

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void validarCampos(PedidoItens pedidoItens) throws RegraException {

		if (pedidoItens.getPedido() == null) {

			throw new RegraException("Pedido inválido!");

		}

		if (pedidoItens.getProduto() == null) {

			throw new RegraException("Produto inválido!");

		}

		if (pedidoItens.getPrecoUnitario() <= 0.0) {

			throw new RegraException("Preço unitário inválido!");

		}

		if (pedidoItens.getQuantidade() == 0) {

			throw new RegraException("Quantidade inválida!");

		}
	}

	public PedidoItens verificaDuplicidade(PedidoItens pedidoItens) throws RegraException {

		try {

			PedidoItens x = dao.pesquisar(pedidoItens.getId());

			if (x != null) {

				throw new RegraException("Item pedido já existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}

		return pedidoItens;
	}

	public void validaIdNull(Integer id) throws RegraException {

		if (id == null) {

			throw new RegraException("Id inválido!");

		}
	}

	public void validaIdExistente(Integer id) throws RegraException {

		try {

			PedidoItens x = dao.pesquisar(id);

			if (x != null) {

				throw new RegraException("Id informado existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}
}
