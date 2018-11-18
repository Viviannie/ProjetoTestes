package testes.unidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testValidarDescricao() {
		
		stPed.setDescricao("StatusPedidoRN teste descricão.");

		try {

			assertTrue("Exceção validar Descrição StatusPedido OK!", rnStPed.validarDescricao(stPed));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}
	
	@Test(expected = NullPointerException.class)
	public void testeStatusPedidoNull() {		

		stPed.setDescricao(null);
		stPed.setId(idNull);

		try {
			
			rnStPed.incluir(stPed);
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}
	}

	@Test
	public void testValidarDuplicidadeId() {

		StatusPedido statPed1 = new StatusPedido();
		StatusPedido statPed2 = new StatusPedido();

		statPed1.setId(1);
		statPed2.setId(1);	

		try {
			
			rnStPed.incluir(statPed1);
			rnStPed.incluir(statPed2);
			
			assertEquals("Pedido já existe.", rnStPed.verificaDuplicidade(statPed1), rnStPed.verificaDuplicidade(statPed2));
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}
	
	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() {
		
		try {
			
			Integer id = null;
			stPed.setId(id);
			
			rnStPed.validaIdNull(stPed.getId());
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}

	@After
	public void limparCliente() {

		stPed = new StatusPedido();		

	}
}
