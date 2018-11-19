package testes.unidade;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Categoria;
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

	@Test
	public void testValidarDescricaoMenorQue25Caracteres() {

		pro.setDescricao("ProdutoRN descricão.");

		assertFalse(rnPro.validarDescricao(pro));

	}
	
	@Test
	public void testValidarDescricaoMaiorQue25Caracteres() {

		pro.setDescricao("ProdutoRN teste descricão JUnit.");

		assertTrue(rnPro.validarDescricao(pro));

	}
	
	@Test(expected = RegraException.class)
	public void testValidarValorProdutoIgualAZero() throws RegraException {

		pro.setPrecoUnitario(0.0);
		pro.setDescricao("Descricao");
		
		Categoria cat = new Categoria();
		cat.setId(1);
		pro.setCategoria(cat);

		pro.setAtivo('1');
		rnPro.validarCampos(pro);
	}
	
	@Test(expected = RegraException.class)
	public void testValidarCamposProdutoAtivoIgualAZero() throws RegraException {

		pro.setPrecoUnitario(10.0);
		pro.setDescricao("Descricao");
		
		Categoria cat = new Categoria();
		cat.setId(1);
		pro.setCategoria(cat);

		pro.setAtivo('0');
		rnPro.validarCampos(pro);
	}
	
	@Test(expected = RegraException.class)
	public void testValidarCamposProdutoDescricaoNula() throws RegraException {

		pro.setPrecoUnitario(10.0);
		pro.setDescricao(null);
		
		Categoria cat = new Categoria();
		cat.setId(1);
		pro.setCategoria(cat);

		pro.setAtivo('1');
		rnPro.validarCampos(pro);
	}
	
	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() throws RegraException {

		pro.setId(idNull);

		rnPro.validaIdNull(pro.getId());

	}

	@After
	public void limparCliente() {

		pro = new Produto();

	}
}
