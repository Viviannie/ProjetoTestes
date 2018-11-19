package testes.unidade;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Produto;
import model.excecoes.RegraException;
import model.regra.RNProduto;

public class ProdutoRNTest {

	public Produto pro;
	public RNProduto rnPro;
	Integer idNull = null;

	@Before
	public void init() {

		this.pro = new Produto();
		this.rnPro = new RNProduto();

	}

	@Test(expected = RegraException.class)
	public void testValidarDescricao() throws RegraException {

		pro.setDescricao("ProdutoRN teste descricão.");

		rnPro.validarDescricao(pro);

	}
	
	@Test(expected = RegraException.class)
	public void testValidarIdNull() throws RegraException {

		pro.setId(idNull);

		rnPro.validaIdNull(pro.getId());

	}

	@After
	public void limparCliente() {

		pro = new Produto();

	}
}
