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

//	@Test
//	public void testValidarDuplicidadeId() {
//
//		Produto pro1 = new Produto();
//		Produto pro2 = new Produto();
//
//		pro1.setId(1);
//		pro2.setId(1);
//
//		try {
//
//			rnPro.incluir(pro1);
//			rnPro.incluir(pro2);
//
//			assertEquals("Exceção validar Duplicidade ID Produto OK!", rnPro.verificaDuplicidade(pro1),
//					rnPro.verificaDuplicidade(pro2));
//
//		} catch (RegraException e) {
//
//			e.printStackTrace();
//
//		}
//	}

	@After
	public void limparCliente() {

		pro = new Produto();

	}
}
