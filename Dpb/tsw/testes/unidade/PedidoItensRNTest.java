package testes.unidade;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.PedidoItens;
import model.excecoes.RegraException;
import model.regra.RNPedidoItens;

public class PedidoItensRNTest {

	public PedidoItens pedIt;
	public RNPedidoItens rnPedIt;
	Integer idNull = null;

	@Before
	public void init() {

		this.pedIt = new PedidoItens();
		this.rnPedIt = new RNPedidoItens();

	}

//	@Test
//	public void testValidarDuplicidadeId() {
//
//		PedidoItens pedIt1 = new PedidoItens();
//		PedidoItens pedIt2 = new PedidoItens();
//
//		pedIt1.setId(1);
//		pedIt2.setId(1);
//
//		rnPedIt.incluir(pedIt1);
//		rnPedIt.incluir(pedIt2);
//
//		assertEquals("Exceção validar Duplicidade ID PedidoItens OK!", rnPedIt.verificaDuplicidade(pedIt1),
//				rnPedIt.verificaDuplicidade(pedIt2));
//
//	}

	@Test(expected = RegraException.class)
	public void testValidarIdNull() throws RegraException {

		pedIt.setId(idNull);

		rnPedIt.validaIdNull(pedIt.getId());
		
	}

	@After
	public void limparCliente() {

		pedIt = new PedidoItens();

	}
}
