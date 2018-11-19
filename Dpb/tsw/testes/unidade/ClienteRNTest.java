package testes.unidade;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Cliente;
import model.excecoes.RegraException;
import model.regra.RNCliente;

public class ClienteRNTest {

	public Cliente cli;
	public RNCliente rnCli;
	Integer idNull = null;

	@Before
	public void init() {

		this.cli = new Cliente();
		this.rnCli = new RNCliente();

	}

	@Test(expected = RegraException.class)
	public void testValidarRazaoSocial() throws RegraException {

		cli.setRazaoSocial("Descartáveis Multi Plásticos do Brasil Ltda.");

		assertTrue("Exceção validar Razão Social Cliente OK!", rnCli.validarRazaoSocial(cli));

	}

	@Test(expected = RegraException.class)
	public void testValidarNomeFantasia() throws RegraException {

		cli.setNomeFantasia("Multi Descartáveis Plásticos.");

		assertTrue("Exceção validar Nome Fantasia Cliente OK!", rnCli.validarNomeFantasia(cli));

	}

	@Test(expected = RegraException.class)
	public void testValidarCnpj() throws RegraException {

		cli.setCnpj("1234567891234564");

		rnCli.validarCnpj(cli);

	}

	@Test(expected = RegraException.class)
	public void testValidarEmail() throws RegraException {

		cli.setEmail("annievivianelessadacunhasantanabezerradasilva@gmail.com");

		rnCli.validarEmail(cli);

	}

//	@Test
//	public void testValidarDuplicidadeCnpj() {
//
//		Cliente cli1 = new Cliente();
//		Cliente cli2 = new Cliente();
//
//		cli1.setCnpj("12345678912345");
//		cli2.setCnpj("12345678912345");
//
//		rnCli.incluir(cli1);
//		rnCli.incluir(cli2);
//
//		assertEquals("Exceção validar Duplicidade CNPJ Cliente OK!", rnCli.verificaDuplicidade(cli1),
//				rnCli.verificaDuplicidade(cli2));
//
//	}

	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() throws RegraException {

		cli.setId(idNull);

		rnCli.validaIdNull(cli.getId());

	}

	@After
	public void limparCliente() {

		cli = new Cliente();

	}
}