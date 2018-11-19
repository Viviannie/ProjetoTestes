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

//	@Test
//	public void testValidarDuplicidadeId() {
//
//		Pedido ped1 = new Pedido();
//		Pedido ped2 = new Pedido();
//
//		ped1.setId(1);
//		ped2.setId(1);
//
//		try {
//
//			rnPed.incluir(ped1);
//			rnPed.incluir(ped2);
//
//			assertEquals("Exceção validar Dupliciade ID Pedido OK!", rnPed.verificaDuplicidade(ped1),
//					rnPed.verificaDuplicidade(ped2));
//
//	}

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
