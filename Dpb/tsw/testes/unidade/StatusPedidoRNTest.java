package testes.unidade;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.StatusPedido;
import model.excecoes.RegraException;
import model.regra.RNStatusPedido;

public class StatusPedidoRNTest {

	public StatusPedido stPed;
	public RNStatusPedido rnStPed;
	Integer idNull = null;

	@Before
	public void init() {

		this.stPed = new StatusPedido();
		this.rnStPed = new RNStatusPedido();

	}

	@Test(expected = RegraException.class)
	public void testValidarDescricao() throws RegraException {

		stPed.setDescricao("StatusPedidoRN teste descricão.");

		rnStPed.validarDescricao(stPed);

	}

	@Test(expected = RegraException.class)
	public void testeStatusPedidoNull() throws RegraException {

		stPed.setDescricao(null);
		stPed.setId(idNull);

		rnStPed.incluir(stPed);

	}

//	@Test
//	public void testValidarDuplicidadeId() {
//
//		StatusPedido statPed1 = new StatusPedido();
//		StatusPedido statPed2 = new StatusPedido();
//
//		statPed1.setId(1);
//		statPed2.setId(1);
//
//		try {
//
//			rnStPed.incluir(statPed1);
//			rnStPed.incluir(statPed2);
//
//			assertEquals("Pedido já existe.", rnStPed.verificaDuplicidade(statPed1),
//					rnStPed.verificaDuplicidade(statPed2));
//
//		} catch (RegraException e) {
//
//			e.printStackTrace();
//
//		}
//	}

	@Test(expected = RegraException.class)
	public void testValidarIdNull() throws RegraException {

		stPed.setId(idNull);

		rnStPed.validaIdNull(stPed.getId());

	}

	@After
	public void limparCliente() {

		stPed = new StatusPedido();

	}
}
