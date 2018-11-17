package testes.unidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Categoria;
import model.excecoes.RegraException;
import model.regra.RNCategoria;

//@DisplayName("Testes de assertions para CategoriaRN")
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
	public void testValidarDescricao() {

		cat.setDescricao("Categoria a confirmar porque esse é só um exemplo para teste.");

		try {

			assertTrue("Exceção validar descrição categoria OK!", rnCat.validarDescricao(cat));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}	

	@Test
	public void testValidarDuplicidadeCategoria() {

		Categoria cat1 = new Categoria();
		Categoria cat2 = new Categoria();

		cat1.setId(1);
		cat2.setId(1);	

		try {

			rnCat.incluir(cat1);
			rnCat.incluir(cat2);

			assertEquals("Exceção validar duplicidade categoria OK!", rnCat.verificaDuplicidade(cat1), rnCat.verificaDuplicidade(cat2));


		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}
	
	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() {

		try {
		
			cat.setId(idNull);
			
			rnCat.validaIdNull(cat.getId());
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}

	@After
	public void limparCategoria() {

		cat = new Categoria();		

	}
}
