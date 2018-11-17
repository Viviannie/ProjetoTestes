package testes.unidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Produto;
import model.excecoes.RegraException;
import model.regra.RNProduto;

//@DisplayName("Testes de assertions para ProdutoRN")
public class ProdutoRNTest {

	public RNProduto rnPro = new RNProduto();

	@Before
	public void init() {

		this.rnPro = new RNProduto();

	}
	
	@Test
	public void testValidarDescricao() {

		Produto pro = new Produto();

		pro.setDescricao("ProdutoRN teste descric�o.");

		try {

			assertTrue("Exce��o validar Descri��o Produto OK!", rnPro.validarDescricao(pro));

		} catch (RegraException e) {

			e.printStackTrace();

		}	
	}

	@Test
	public void testValidarDuplicidadeId() {

		Produto pro1 = new Produto();
		Produto pro2 = new Produto();

		pro1.setId(1);
		pro2.setId(1);		

		try {
			
			rnPro.incluir(pro1);
			rnPro.incluir(pro2);
			
			assertEquals("Exce��o validar Duplicidade ID Produto OK!", rnPro.verificaDuplicidade(pro1), rnPro.verificaDuplicidade(pro2));
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}
	
	@Test
	public void testValidarId() {			

		try {
			rnPro.validaId(null);
		} catch (RegraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Exce��o validar ID Produto OK!", rnPro);

	}

	@After
	public void limparCliente() {

		Produto pro = new Produto();

		pro = new Produto();		

	}
}
