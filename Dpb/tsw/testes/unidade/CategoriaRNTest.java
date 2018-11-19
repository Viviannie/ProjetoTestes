package testes.unidade;

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

	@Test(expected = RegraException.class) 
	public void testValidarDescricao() throws RegraException {

		cat.setDescricao("Categoria a confirmar porque esse é só um exemplo para teste.");
		rnCat.validarDescricao(cat);

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
	
	@Test(expected = RegraException.class) 
	public void testValidarCamposCorreto() throws RegraException {

		cat.setDescricao("Descrição da Categoria");
		rnCat.validarCampos(cat);

	}
	
// Esse teste é Funcional.
//	@Test (expected = RegraException.class) 
//	public void testValidarDuplicidadeCategoria() throws RegraException {
//
//		Categoria cat1 = new Categoria();
//		Categoria cat2 = new Categoria();
//
//		cat1.setId(1);
//		cat2.setId(1);
//
//		rnCat.incluir(cat1);
//		rnCat.incluir(cat2);
//
//		rnCat.verificaDuplicidade(cat1); // conversar com Jefferson.
//
//	}

	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() throws RegraException {

		cat.setId(idNull);
		
		rnCat.validaIdNull(idNull);
	}

	@After
	public void limparCategoria() {

		cat = new Categoria();

	}
}
