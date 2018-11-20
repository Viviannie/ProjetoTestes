package testes.unidade;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.classesbasicas.Vendedor;
import model.regra.RNVendedor;

public class VendedorRNTest {

	public Vendedor vend;
	public RNVendedor rnVend;
	Integer idNull = null;

	@Before
	public void init() {

		this.vend = new Vendedor();
		this.rnVend = new RNVendedor();

	}

	@Test
	public void testValidarNomeComMaisDe50Caracteres() {

		vend.setNome("Annie Viviane Lessa da Cunha Santana Bezerra da Silva");

		assertTrue(rnVend.validarNome(vend));

	}
	
	@Test
	public void testValidarNomeComMenosDe50Caracteres() {

		vend.setNome("Vendedor JUnit");

		assertFalse(rnVend.validarNome(vend));

	}

	@Test
	public void testValidarCpfComMaisDe14Caracteres() {

		vend.setCpf("1234567895236400");

		assertTrue(rnVend.validarCpf(vend));

	}
	
	@Test
	public void testValidarCpfComMenosDe14Caracteres() {

		vend.setCpf("12345678950");

		assertTrue(rnVend.validarCpf(vend));

	}
	
	@Test
	public void testValidarCpfCom14Caracteres() {

		vend.setCpf("12345678952364");

		assertFalse(rnVend.validarCpf(vend));

	}

	@Test
	public void testValidarEmailMaiorQue50() {

		vend.setEmail("annievivianelessadacunhasantanabezerradasilva@gmail.com");

		assertTrue(rnVend.validarEmail(vend));

	}

	@Test
	public void testValidarSenhaComMaisDe32Caracteres() {

		vend.setSenha("1234567891234dasdasdhasiuhadsahdsauhsdoiuahsddiuh564");

		assertTrue(rnVend.validarSenha(vend));

	}
	
	@Test
	public void testValidarSenhaComMenos32Caracteres() {

		vend.setSenha("1234567891234dasdasdhasah");

		assertFalse(rnVend.validarSenha(vend));

	}
	
	@Test
	public void testValidarSenhaCom32Caracteres() {

		vend.setSenha("1234567891234dasdasdhasiuhadsah");

		assertFalse(rnVend.validarSenha(vend));

	}

	@After
	public void limparCliente() {

		vend = new Vendedor();

	}
}
