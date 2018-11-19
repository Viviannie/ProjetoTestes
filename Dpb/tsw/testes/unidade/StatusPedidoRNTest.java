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
