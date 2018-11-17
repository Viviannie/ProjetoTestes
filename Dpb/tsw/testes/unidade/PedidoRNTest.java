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

	public Pedido ped;
	public RNPedido rnPed;
	Integer idNull = null;

	@Before
	public void init() {

		this.ped = new Pedido();
		this.rnPed = new RNPedido();

	}
	
	@Test(expected = NullPointerException.class)
	public void testePedidoIncluirNulo() {		
		
		ped.setCliente(null);
		ped.setStatusPedido(null);
		ped.setVendedor(null);
		ped.setDataPedido(null);
		ped.setDataEnvio(null);
		ped.setId(idNull);

		try {

			rnPed.incluir(ped);

		} catch (RegraException e) {

			e.printStackTrace();

		}
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
		
	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() {				

		try {
			
			ped.setId(idNull);
			
			rnPed.validaIdNull(ped.getId());
			
		} catch (RegraException e) {
			
			e.printStackTrace();
			
		}
	}

	@After
	public void limparCliente() {

		ped = new Pedido();		

	}
}
