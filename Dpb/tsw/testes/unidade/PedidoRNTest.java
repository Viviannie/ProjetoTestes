package testes.unidade;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Pedido;
import model.excecoes.RegraException;
import model.regra.RNPedido;

//@DisplayName("Testes de assertions para PedidoRN")
public class PedidoRNTest {

	public RNPedido rnPed = new RNPedido();

	@Before
	public void init() {

		this.rnPed = new RNPedido();

	}
	
	@Test(expected = NullPointerException.class)
	public void testePedidoRegraException() {		

		Pedido ped = new Pedido();	

					ped.setCliente(null);
					ped.setStatusPedido(null);
					ped.setVendedor(null);
					ped.setDataPedido(null);
					ped.setDataEnvio(null);
					ped.setId(0);

					try {
						rnPed.incluir(ped);
					} catch (RegraException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					assertEquals("Exceção validar RegraException Pedido OK!", rnPed);
	}

	@Test
	public void testValidarDuplicidadeId() {

		Pedido ped1 = new Pedido();
		Pedido ped2 = new Pedido();

		ped1.setId(1);
		ped2.setId(1);	

		try {
			
			rnPed.incluir(ped1);
			rnPed.incluir(ped2);
			
			assertEquals("Exceção validar Dupliciade ID Pedido OK!", rnPed.verificaDuplicidade(ped1), rnPed.verificaDuplicidade(ped2));
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}
	
	@Test
	public void testValidarId() {

		try {
			rnPed.validaId(null);
		} catch (RegraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Exceção validar ID Pedido OK!", rnPed);

	}

	@After
	public void limparCliente() {

		Pedido ped = new Pedido();

		ped = new Pedido();		

	}
}
