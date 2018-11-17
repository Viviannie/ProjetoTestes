package testes.unidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Cliente;
import model.excecoes.RegraException;
import model.regra.RNCliente;

//@DisplayName("Testes de assertions para ClienteRN")
public class ClienteRNTest {

	public RNCliente rnCli = new RNCliente();

	@Before
	public void init() {

		this.rnCli = new RNCliente();

	}

	@Test
	public void testValidarRazaoSocial() {

		Cliente cli = new Cliente();

		cli.setRazaoSocial("Descart�veis Multi Pl�sticos do Brasil Ltda.");

		try {

			assertTrue("Exce��o validar Raz�o Social Cliente OK!", rnCli.validarRazaoSocial(cli));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test
	public void testValidarNomeFantasia() {

		Cliente cli = new Cliente();

		cli.setNomeFantasia("Multi Descart�veis Pl�sticos.");

		try {

			assertTrue("Exce��o validar Nome Fantasia Cliente OK!", rnCli.validarNomeFantasia(cli));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test
	public void testValidarCnpj() {

		Cliente cli = new Cliente();

		cli.setCnpj("1234567891234564");

		try {

			assertTrue("Exce��o validar CNPJ Cliente OK!", rnCli.validarCnpj(cli));

		} catch (RegraException e) {

			e.printStackTrace();

		}		
	}

	@Test
	public void testValidarEmail() {

		Cliente cli = new Cliente();

		cli.setEmail("annievivianelessadacunhasantanabezerradasilva@gmail.com");

		try {

			assertTrue("Exce��o validar E-mail Cliente OK!", rnCli.validarEmail(cli));

		} catch (RegraException e) {

			e.printStackTrace();

		}	
	}

	@Test(expected = NullPointerException.class)
	public void testValidarDuplicidadeCnpj() {

		Cliente cli1 = new Cliente();
		Cliente cli2 = new Cliente();

		cli1.setCnpj("12345678912345");
		cli2.setCnpj("12345678912345");		

		try {
			
			rnCli.incluir(cli1);
			rnCli.incluir(cli2);
			
			assertEquals("Exce��o validar Duplicidade CNPJ Cliente OK!", rnCli.verificaDuplicidade(cli1), rnCli.verificaDuplicidade(cli2));
			
		} catch (RegraException e) {

			e.printStackTrace();
			
		}		
	}
	
	@Test(expected = NullPointerException.class)
	public void testValidarId() {				

		try {
			rnCli.validaId(null);
		} catch (RegraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Exce��o validar ID Cliente OK!", rnCli);

	}

	@After
	public void limparCliente() {

		Cliente cli = new Cliente();

		cli = new Cliente();		

	}
}