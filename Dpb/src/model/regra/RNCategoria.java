package model.regra;

import java.util.ArrayList;

import model.classesbasicas.Categoria;
import model.dao.DAOCategoria;
import model.dao.DAOCategoriaImpl;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;
import model.excecoes.RegraException;

public class RNCategoria {

	private final DAOCategoria dao = new DAOCategoriaImpl();

	public void incluir(Categoria categoria) throws RegraException {

		try {

			dao.incluir(categoria);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void alterar(Categoria categoria) throws RegraException {

		try {

			dao.alterar(categoria);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void excluir(Categoria categoria) throws RegraException {

		try {

			dao.excluir(categoria);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Categoria pesquisar(Integer id) throws RegraException {

		try {

			return dao.pesquisar(id);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Categoria pesquisar(String descricao) throws RegraException {

		try {

			return dao.pesquisar(descricao);

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public ArrayList<Categoria> listar() throws RegraException {

		try {

			return dao.listar();

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void validarCampos(Categoria categoria) throws RegraException {

		if ((categoria.getDescricao() == null) || (categoria.getDescricao().trim().equals(""))
				|| (categoria.getDescricao().isEmpty())) {

			throw new RegraException("Descrição inválida!");

		}
	}

	public boolean validarDescricao(Categoria categoria) {

		return (categoria.getDescricao().length() > 25);

	}

	public Categoria verificaDuplicidade(Categoria categoria) throws RegraException {

		try {

			Categoria x = dao.pesquisar(categoria.getId());

			if (x != null) {

				throw new RegraException("Categoria já existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}

		return categoria;

	}

	public Integer validaIdNull(Integer id) throws RegraException {

		if (id == null) {

			throw new RegraException("Id inválido!");

		}
		
		return id;
	}

	public void validaIdExistente(Integer id) throws RegraException {

		try {

			Categoria x = dao.pesquisar(id);

			if (x != null) {

				throw new RegraException("Id informado existe.");

			}

		} catch (ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}
}
