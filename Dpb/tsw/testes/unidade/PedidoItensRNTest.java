package testes.unidade;

import org.junit.After;
import org.junit.Before;

import model.classesbasicas.PedidoItens;
import model.regra.RNPedidoItens;

public class PedidoItensRNTest {

	public PedidoItens pedIt;
	public RNPedidoItens rnPedIt;

	@Before
	public void init() {

		this.pedIt = new PedidoItens();
		this.rnPedIt = new RNPedidoItens();

	}

	@After
	public void limparCliente() {

		pedIt = new PedidoItens();

	}
}
