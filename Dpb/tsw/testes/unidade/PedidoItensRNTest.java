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

	@Before
	public void init() {

		this.pedIt = new PedidoItens();
		this.rnPedIt = new RNPedidoItens();

	}
	
	@Test(expected = RegraException.class)
	public void testValidarPrecoUnitarioZerado() throws RegraException {

		pedIt.setPrecoUnitario(0.0);
		
		rnPedIt.validarCampos(pedIt);
		
	}
	
	@Test(expected = RegraException.class)
	public void testValidarPrecoUnitarioMenorQueZero() throws RegraException {

		pedIt.setPrecoUnitario(-10.0);
		
		rnPedIt.validarCampos(pedIt);
		
	}

	@After
	public void limparCliente() {

		pedIt = new PedidoItens();

	}
}
