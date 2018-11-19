package testes.unidade;

import static org.junit.Assert.assertFalse;
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

	@Test
	public void testValidarRazaoSocialCorreto() {

		cli.setRazaoSocial("Descartáveis Multi Plásticos do Br Ltda.");

		assertFalse(rnCli.validarRazaoSocial(cli));

	}
	
	@Test
	public void testValidarRazaoSocialComMaisDe40Caracteres() {

		cli.setRazaoSocial("Descartáveis Multi Plásticos do Brasil Ltda.");

		assertTrue(rnCli.validarRazaoSocial(cli));

	}

	@Test
	public void testValidarNomeFantasiaCorreto() throws RegraException {

		cli.setNomeFantasia("Multi Descartáveis Plast.");

		assertFalse(rnCli.validarNomeFantasia(cli));

	}
	
	@Test
	public void testValidarNomeFantasiaComMaisDe20Caracteres() throws RegraException {

		cli.setNomeFantasia("Multi Descartáveis Plásticos do Brasil.");

		assertTrue(rnCli.validarNomeFantasia(cli));

	}
	
	@Test
	public void testValidarCnpjCom14Caracteres() {

		cli.setCnpj("12345678912345");

		assertFalse(rnCli.validarCnpj(cli));

	}
	
	@Test
	public void testValidarCnpjComMenosDe14Caracteres() {

		cli.setCnpj("1234567891234");

		assertTrue(rnCli.validarCnpj(cli));

	}

	@Test
	public void testValidarCnpjComMaisDe14Caracteres() {

		cli.setCnpj("1234567891234564");

		assertTrue(rnCli.validarCnpj(cli));

	}

	@Test
	public void testValidarEmailComMaisDe50Caracteres() throws RegraException {

		cli.setEmail("annievivianelessadacunhasantanabezerradasilva@gmail.com");

		assertTrue(rnCli.validarEmail(cli));

	}
	
	@Test
	public void testValidarEmailComMenosDe50Caracteres() throws RegraException {

		cli.setEmail("annievivianelessadacunhasantanabs@gmail.com");

		assertFalse(rnCli.validarEmail(cli));

	}

	@Test(expected = RegraException.class)
	public void testValidarIdNull() throws RegraException {

		cli.setId(idNull);

		rnCli.validaIdNull(cli.getId());

	}

	@After
	public void limparCliente() {

		cli = new Cliente();

	}
}