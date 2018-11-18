package testes.unidade;

import static org.junit.Assert.assertEquals;

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

	@Test
	public void testValidarDuplicidadeId() {

		PedidoItens pedIt1 = new PedidoItens();
		PedidoItens pedIt2 = new PedidoItens();

		pedIt1.setId(1);
		pedIt2.setId(1);	

		try {
			
			rnPedIt.incluir(pedIt1);
			rnPedIt.incluir(pedIt2);
			
			assertEquals("Exceção validar Duplicidade ID PedidoItens OK!", rnPedIt.verificaDuplicidade(pedIt1), rnPedIt.verificaDuplicidade(pedIt2));
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}
	
	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() {	

		try {
			
			pedIt.setId(idNull);
			
			rnPedIt.validaIdNull(pedIt.getId());
			assertEquals("Exceção validar ID PedidoItens OK!", rnPedIt);
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}
	}

	@After
	public void limparCliente() {

		pedIt = new PedidoItens();		

	}
}
