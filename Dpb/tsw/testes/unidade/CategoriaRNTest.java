package testes.unidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Categoria;
import model.excecoes.RegraException;
import model.regra.RNCategoria;

public class CategoriaRNTest {

	public RNCategoria rnCat = new RNCategoria();
	public Categoria cat = new Categoria();
	Integer idNull = null;

	@Before
	public void init() {

		this.rnCat = new RNCategoria();
		this.cat = new Categoria();

	}
	
	@Test
	public void testValidarTamanhoDescricaoMaiorQueOPermitido() throws RegraException {

		cat.setDescricao("Caracteres da Categoria maior do que 25 caracteres é um exemplo para teste.");
		boolean retorno = rnCat.validarDescricao(cat);
		assertTrue(retorno);

	}
	
	@Test
	public void testValidarTamanhoDescricaoDeAcordoComOPermitido() throws RegraException {

		cat.setDescricao("Caracteres da Categoria.");
		boolean retorno = rnCat.validarDescricao(cat);
		assertFalse(retorno);

	}
	
	@Test(expected = RegraException.class) 
	public void testValidarCamposComErro() throws RegraException {

		cat.setDescricao(null);
		rnCat.validarCampos(cat);

	}
	
	@Test
	public void testValidarCamposCorreto() throws RegraException {

		cat.setDescricao("Descrição da Categoria");
		rnCat.validarCampos(cat);

	}

	@Test
	public void testValidarComValor() throws RegraException {

		cat.setId(10);
		
		Integer retorno = rnCat.validaIdNull(cat.getId());
		assertEquals(10, retorno, 0);
		
	}

	@After
	public void limparCategoria() {

		cat = new Categoria();

	}
}
