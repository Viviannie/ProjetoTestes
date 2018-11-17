package model.regra;

import java.util.ArrayList;

import model.classesbasicas.Produto;
import model.dao.DAOProduto;
import model.dao.DAOProdutoImpl;
import model.excecoes.ConexaoException;
import model.excecoes.DAOException;
import model.excecoes.RegraException;

public class RNProduto {

	private final DAOProduto dao = new DAOProdutoImpl();

	public void incluir(Produto produto) throws RegraException {

		try {

			dao.incluir(produto);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void alterar(Produto produto)throws RegraException {

		try {

			dao.alterar(produto);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public void excluir(Produto produto) throws RegraException {

		try {

			dao.excluir(produto);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Produto pesquisar(Integer id) throws RegraException {

		try {

			return dao.pesquisar(id);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}

	public Produto pesquisar(String descricao) throws RegraException {

		try {

			return dao.pesquisar(descricao);

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
	}	

	public ArrayList<Produto> listar() throws RegraException {

		try {

			return dao.listar();

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}        
	}

	public void validarCampos(Produto produto) throws RegraException {

		if ((produto.getDescricao() == null) || (produto.getDescricao().trim().equals("")) || (produto.getDescricao().isEmpty())) {

			throw new RegraException("Descrição inválida!");

		}	
		
		if (produto.getPrecoUnitario() == 0.0) {

			throw new RegraException("Preço unitário inválido!");

		}
		
		if (produto.getCategoria() == null) {

			throw new RegraException("Categoria inválida!");

		}
		
		if (produto.getAtivo() == 0) {

			throw new RegraException("Ativação inválida!");

		}			
	}
	
	public boolean validarDescricao(Produto produto) throws RegraException {
		
		return produto.getDescricao().length() > 25;
		
	}

	public Produto verificaDuplicidade(Produto produto) throws RegraException {

		try {

			Produto x = dao.pesquisar(produto.getId());

			if(x != null) {

				throw new RegraException("Produto já existe.");

			}

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}
		
		return produto;
		
	}

	public void validaId(Integer id) throws RegraException {

		if(id == null) {

			throw new RegraException("Id inválido!");

		}

		try {

			Produto x = dao.pesquisar(id);

			if(x == null) {

				throw new RegraException("Id informado não existe.");

			}

		} catch(ConexaoException | DAOException e) {

			throw new RegraException(e.getMessage());

		}        
	}
}
