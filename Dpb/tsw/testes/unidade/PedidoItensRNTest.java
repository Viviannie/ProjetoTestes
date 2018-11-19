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
