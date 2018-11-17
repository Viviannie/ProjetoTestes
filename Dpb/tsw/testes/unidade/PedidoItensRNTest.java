package testes.unidade;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.PedidoItens;
import model.excecoes.RegraException;
import model.regra.RNPedidoItens;

//@DisplayName("Testes de assertions para PedidoItensRN")
public class PedidoItensRNTest {

	public RNPedidoItens rnPedIt = new RNPedidoItens();

	@Before
	public void init() {

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
	
	@Test
	public void testValidarId() {	

		try {
			
			rnPedIt.validaId(null);
			assertEquals("Exceção validar ID PedidoItens OK!", rnPedIt);
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}
	}

	@After
	public void limparCliente() {

		PedidoItens pedIt = new PedidoItens();

		pedIt = new PedidoItens();		

	}
}
