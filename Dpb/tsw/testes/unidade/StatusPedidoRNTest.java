package testes.unidade;

import static org.junit.Assert.assertFalse;
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
	public void testValidarDescricaoComMenosDe25Caracteres() {

		stPed.setDescricao("StatusPedidoRN");

		assertFalse(rnStPed.validarDescricao(stPed));

	}
	
	@Test
	public void testValidarDescricaoComMaisDe25Caracteres() {

		stPed.setDescricao("StatusPedidoRN teste descricão JUnit com Mais de 25 caracteres");

		assertTrue(rnStPed.validarDescricao(stPed));

	}

	@Test(expected = NullPointerException.class)
	public void testeStatusPedidoNull() throws RegraException {

		stPed.setDescricao(null);
		stPed.setId(idNull);

		rnStPed.incluir(stPed);

	}
	
	@Test(expected = RegraException.class)
	public void testeStatusValidarCampoDescricaoNulo() throws RegraException {

		stPed.setDescricao(null);

		rnStPed.incluir(stPed);

	}
	
	@Test(expected = RegraException.class)
	public void testeStatusValidarCampoDescricaoEmBranco() throws RegraException {

		stPed.setDescricao("");

		rnStPed.incluir(stPed);

	}

	@After
	public void limparCliente() {

		stPed = new StatusPedido();

	}
}
