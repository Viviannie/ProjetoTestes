package testes.unidade;

import static org.junit.Assert.assertEquals;
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
	public void testValidarRazaoSocial() {

		cli.setRazaoSocial("Descartáveis Multi Plásticos do Brasil Ltda.");

		try {

			assertTrue("Exceção validar Razão Social Cliente OK!", rnCli.validarRazaoSocial(cli));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test
	public void testValidarNomeFantasia() {

		cli.setNomeFantasia("Multi Descartáveis Plásticos.");

		try {

			assertTrue("Exceção validar Nome Fantasia Cliente OK!", rnCli.validarNomeFantasia(cli));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test
	public void testValidarCnpj() {

		cli.setCnpj("1234567891234564");

		try {

			assertTrue("Exceção validar CNPJ Cliente OK!", rnCli.validarCnpj(cli));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test
	public void testValidarEmail() {

		cli.setEmail("annievivianelessadacunhasantanabezerradasilva@gmail.com");

		try {

			assertTrue("Exceção validar E-mail Cliente OK!", rnCli.validarEmail(cli));

		} catch (RegraException e) {

			e.printStackTrace();

		}	
	}

	@Test
	public void testValidarDuplicidadeCnpj() {

		Cliente cli1 = new Cliente();
		Cliente cli2 = new Cliente();

		cli1.setCnpj("12345678912345");
		cli2.setCnpj("12345678912345");		

		try {
			
			rnCli.incluir(cli1);
			rnCli.incluir(cli2);
			
			assertEquals("Exceção validar Duplicidade CNPJ Cliente OK!", rnCli.verificaDuplicidade(cli1), rnCli.verificaDuplicidade(cli2));
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}
	
	@Test(expected = NullPointerException.class)
	public void testValidarIdNull() {				

		try {
			
			cli.setId(idNull);
			
			rnCli.validaIdNull(cli.getId());
			
		} catch (RegraException e) {
			
			e.printStackTrace();
			
		}
	}

	@After
	public void limparCliente() {

		cli = new Cliente();		

	}
}