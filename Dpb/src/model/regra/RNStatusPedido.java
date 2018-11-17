package model.regra;

import java.util.ArrayList;

import model.classesbasicas.StatusPedido;
import model.dao.DAOStatusPedido;
import model.dao.DAOStatusPedidoImpl;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;
import model.excecoes.RegraException;

public class RNStatusPedido {

	private final DAOStatusPedido dao = new DAOStatusPedidoImpl();

	public void incluir(StatusPedido statusPedido) throws RegraException {

		try {

			dao.incluir(statusPedido);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void alterar(StatusPedido statusPedido)throws RegraException {

		try {

			dao.alterar(statusPedido);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void excluir(StatusPedido statusPedido) throws RegraException {

		try {
			
			dao.excluir(statusPedido);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public StatusPedido pesquisar(Integer id) throws RegraException {

		try {

			return dao.pesquisar(id);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public StatusPedido pesquisar(String descricao) throws RegraException {

		try {
			
			return dao.pesquisar(descricao);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}	

	public ArrayList<StatusPedido> listar() throws RegraException {

		try {

			return dao.listar();

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}        
	}

	public void validarCampos(StatusPedido statusPedido) throws RegraException {

		if ((statusPedido.getDescricao() == null) || (statusPedido.getDescricao().trim().equals("")) || (statusPedido.getDescricao().isEmpty())) {

			throw new RegraException("Descrição inválida!");

		}
	}
	
	public boolean validarDescricao(StatusPedido statusPedido) throws RegraException {

		return statusPedido.getDescricao().length() > 25;
		
	}

	public StatusPedido verificaDuplicidade(StatusPedido statusPedido) throws RegraException {

		try {

			StatusPedido x = dao.pesquisar(statusPedido.getId());

			if(x != null) {

				throw new RegraException("Status do pedido já existe.");

			}

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
		
		return statusPedido;
		
	}

	public void validaId(Integer id) throws RegraException {

		if(id == null) {

			throw new RegraException("Id inválido!");

		}

		try {

			StatusPedido x = dao.pesquisar(id);

			if(x == null) {

				throw new RegraException("Id informado não existe.");

			}

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}        
	}
}
