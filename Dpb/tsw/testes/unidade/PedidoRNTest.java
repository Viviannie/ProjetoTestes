package testes.unidade;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Pedido;
import model.excecoes.RegraException;
import model.regra.RNPedido;

public class PedidoRNTest {

	public Pedido ped;
	public RNPedido rnPed;
	Integer idNull = null;

	@Before
	public void init() {

		this.ped = new Pedido();
		this.rnPed = new RNPedido();

	}

	@Test(expected = RegraException.class)
	public void testePedidoIncluirNulo() throws RegraException {

		ped.setCliente(null);
		ped.setStatusPedido(null);
		ped.setVendedor(null);
		ped.setDataPedido(null);
		ped.setDataEnvio(null);
		ped.setId(idNull);

		rnPed.incluir(ped);

	}

	@Test(expected = RegraException.class)
	public void testValidarIdNull() throws RegraException {

		ped.setId(idNull);

		rnPed.validaIdNull(ped.getId());

	}

	@After
	public void limparCliente() {

		ped = new Pedido();

	}
}
