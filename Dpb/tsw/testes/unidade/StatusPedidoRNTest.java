package testes.unidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.StatusPedido;
import model.excecoes.RegraException;
import model.regra.RNStatusPedido;

//@DisplayName("Testes de assertions para StatusPedidoRN")
public class StatusPedidoRNTest {

	public RNStatusPedido rnStatPed = new RNStatusPedido();

	@Before
	public void init() {

		this.rnStatPed = new RNStatusPedido();

	}
	
	@Test
	public void testValidarDescricao() {

		StatusPedido statPed = new StatusPedido();

		statPed.setDescricao("StatusPedidoRN teste descricão.");

		try {

			assertTrue("Exceção validar Descrição StatusPedido OK!", rnStatPed.validarDescricao(statPed));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}
	
	@Test(expected = NullPointerException.class)
	public void testeStatusPedidoRegraException() {		

		StatusPedido statPed = new StatusPedido();

		statPed.setDescricao(null);
		statPed.setId(0);

		try {
			rnStatPed.incluir(statPed);
		} catch (RegraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Exceção validar RegraException StatusPedido OK!", rnStatPed);

	}

	@Test
	public void testValidarDuplicidadeId() {

		StatusPedido statPed1 = new StatusPedido();
		StatusPedido statPed2 = new StatusPedido();

		statPed1.setId(1);
		statPed2.setId(1);	

		try {
			
			rnStatPed.incluir(statPed1);
			rnStatPed.incluir(statPed2);
			
			assertEquals("Pedido já existe.", rnStatPed.verificaDuplicidade(statPed1), rnStatPed.verificaDuplicidade(statPed2));
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}
	
	@Test
	public void testValidarId() {		

		try {
			rnStatPed.validaId(null);
		} catch (RegraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Exceção validar ID StatusPedido OK!", rnStatPed	);

	}

	@After
	public void limparCliente() {

		StatusPedido statPed = new StatusPedido();

		statPed = new StatusPedido();		

	}
}
